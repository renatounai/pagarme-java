package me.pagar.endpoint;

import me.pagar.ApiClient;
import me.pagar.exception.ApiErrors;
import me.pagar.exception.IncompatibleClass;
import me.pagar.exception.Messages;
import me.pagar.generickeyvalueobject.EmptyFieldsOnHash;
import me.pagar.objecttraits.CanBecomeKeyValueVariable;
import me.pagar.objecttraits.CanLoadFieldsFromSources;
import me.pagar.objecttraits.ResourceObject;
import me.pagar.resource.GsonConverter;
import me.pagar.resource.HttpResponse;
import me.pagar.resource.JsonConverter;

import java.io.IOException;
import java.util.*;

/**
 * Resolves endpoint building and calling
 * Resolves possible parsings and middleware stuff after request
 */
public class EndpointConsumer<T extends CanLoadFieldsFromSources, T2 extends EndpointConsumer> {

    private ApiClient client;
    private Action action = Action.GET;
    private LinkedList<String> resources;
    private JsonConverter converter;
    private Class<T> classType;

    //initial configs
    EndpointConsumer(ApiClient client, JsonConverter converter, Class<T> classType) {
        this.client = client;
        this.converter = converter;
        this.classType = classType;
        resources = new LinkedList<String>();
    }

    public EndpointConsumer(ApiClient client, Class<T> classType) {
        this(client, new GsonConverter(), classType);
    }

    /**
     * Set action.
     * Resolves urls ending with special ending actions - calculate_installments, refund, collect_payment, etc
     */
    public T2 create() {
        return setActionAndReturnThis(Action.POST);
    }

    public T2 post() {
        return setActionAndReturnThis(Action.POST);
    }

    public T2 delete() {
        return setActionAndReturnThis(Action.DELETE);
    }

    public T2 update() {
        return setActionAndReturnThis(Action.PUT);
    }

    public T2 find() {
        return setActionAndReturnThis(Action.GET);
    }

    private T2 setActionAndReturnThis(Action action) {
        this.action = action;
        return (T2)this;
    }

    /**
     * Set intermediary resources. May be id'd ones or not
     */
    public T2 thatHas(ApiResources resource) {
        return pushResourcesAndReturnThis(resource.getResourceName());
    }

    public T2 thatHas(String resource) {
        return pushResourcesAndReturnThis(resource);
    }

    public T2 thatHas(ApiResources resource, String id) {
        return pushResourcesAndReturnThis(resource.getResourceName(), id);
    }

    public T2 thatHas(String resource, String id) {
        return pushResourcesAndReturnThis(id, resource);
    }

    public T2 thatHas(ResourceObject object) {
        return pushResourcesAndReturnThis(object.id(), object.object());
    }

    private T2 pushResourcesAndReturnThis(String... resources) {
        for (String resource : resources) {
            this.resources.add(resource);
        }
        return (T2)this;
    }

    private T2 prependResourcesAndReturnThis(String... resources) {
        for (String resource : resources) {
            this.resources.add(0, resource);
        }
        return (T2)this;
    }

    /**
     * Closes the endpoint construction and sends the request with parameters
     */
    public T withParameters(CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors, IncompatibleClass {
        String url = buildUrl(this.resources);
        HttpResponse response = doRequest(url, parameters, new HashMap<String, String>());

        try {
            T newInstance = classType.newInstance();
            newInstance.loadParametersFrom(response.body());
            return newInstance;
        } catch (InstantiationException e) {
            throw new IncompatibleClass(Messages.INCOMPATIBLE_CLASS_FIELDS_ON_HASH, e);
        } catch (IllegalAccessException e) {
            throw new IncompatibleClass(Messages.INCOMPATIBLE_CLASS_FIELDS_ON_HASH, e);
        }
    }

    public T withNoParameters() throws IOException, ApiErrors, IncompatibleClass {
        return withParameters(new EmptyFieldsOnHash());
    }

    public List<T> listWithParameters(CanBecomeKeyValueVariable parameters)
            throws IOException, ApiErrors, IncompatibleClass {
        String url = buildUrl(this.resources);
        HttpResponse response = doRequest(url, parameters, new HashMap<String, String>());

        List<T> castedList = new ArrayList<T>();
        List<Map<String, Object>> convertedJsonList = this.converter.stringToMapList(response.body());
        try {
            for (Map<String, Object> map : convertedJsonList) {
                T classInstance = this.classType.newInstance();
                classInstance.loadParametersFrom(map);
                castedList.add(classInstance);
            }
            return castedList;
        } catch (InstantiationException e) {
            throw new IncompatibleClass(Messages.INCOMPATIBLE_CLASS_FIELDS_ON_HASH, e);
        } catch (IllegalAccessException e) {
            throw new IncompatibleClass(Messages.INCOMPATIBLE_CLASS_FIELDS_ON_HASH, e);
        }
    }

    private HttpResponse doRequest(String url, CanBecomeKeyValueVariable parameters, Map<String, String> headers) throws IOException, ApiErrors {
        HttpResponse response;
        String builtParameters;
        switch (this.action){
            case POST:
                response = this.client.post(url, parameters.toJson(), headers);
                break;

            case DELETE:
                response = this.client.delete(url, parameters.toJson(), headers);
                break;

            case PUT:
                response = this.client.put(url, parameters.toJson(), headers);
                break;

            default:
                response = this.client.get(url, parameters.toQueryString(), headers);
                break;
        }
        if(response.statusCode() > 299) {
            throw new ApiErrors(response.statusCode(), url, this.action.toString(), response.body());
        }
        return response;
    }

    private String buildUrl(List<String> resources) {
        StringBuilder urlBuilder = new StringBuilder();
        while(!resources.isEmpty()) {
            String resource = resources.remove(0);
            urlBuilder.append("/");
            urlBuilder.append(resource);
        }
        return urlBuilder.toString();
    }

    private enum Action {
        POST, GET, PUT, DELETE
    }

}

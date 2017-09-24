package me.pagar.endpoint;

import me.pagar.ApiClient;
import me.pagar.exception.ApiErrors;
import me.pagar.exception.IncompatibleClass;
import me.pagar.exception.Messages;
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
    private Stack<String> resources;
    private JsonConverter converter;
    private Class<T> classType;

    //initial configs
    EndpointConsumer(ApiClient client, JsonConverter converter, Class<T> classType) {
        this.client = client;
        this.converter = converter;
        this.classType = classType;
        resources = new Stack<>();
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

    public T2 delete() {
        return setActionAndReturnThis(Action.DELETE);
    }

    public T2 update() {
        return setActionAndReturnThis(Action.PUT);
    }

    public T2 post(String action) {
        this.resources.push(action);
        return setActionAndReturnThis(Action.POST);
    }

    public T2 find(String id) {
        this.resources.add(id);
        return setActionAndReturnThis(Action.GET);
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
    public T2 of(ApiResources resource) {
        return addResourcesAndReturnThis(resource.getResourceName());
    }

    public T2 of(String resource) {
        return addResourcesAndReturnThis(resource);
    }

    public T2 of(ApiResources resource, String id) {
        return addResourcesAndReturnThis(resource.getResourceName(), id);
    }

    public T2 of(String resource, String id) {
        return addResourcesAndReturnThis(id, resource);
    }

    public T2 of(ResourceObject object) {
        return addResourcesAndReturnThis(object.id(), object.object());
    }

    private T2 addResourcesAndReturnThis(String... resources) {
        for (String resource : resources) {
            this.resources.push(resource);
        }
        return (T2)this;
    }

    /**
     * Closes the endpoint construction and sends the request with parameters
     */
    public T withParameters(CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors, IncompatibleClass {
        StringBuilder urlBuilder = new StringBuilder();
        for (String resource : resources) {
            urlBuilder.append("/");
            urlBuilder.append(resource);
        }
        String url = urlBuilder.toString();
        HttpResponse response = doRequest(url, parameters, new HashMap<>());

        try {
            T newInstance = classType.newInstance();
            newInstance.loadParametersFrom(response.body());
            return newInstance;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IncompatibleClass(Messages.INCOMPATIBLE_CLASS_FIELDS_ON_HASH, e);
        }
    }

    public T withNoParameters() throws IOException, ApiErrors, IncompatibleClass {
        return withParameters(null);
    }

    public <T extends CanLoadFieldsFromSources> List<T> listWithParameters(CanBecomeKeyValueVariable parameters, Class<T> clazz)
            throws IOException, ApiErrors, IncompatibleClass {
        String url = buildUrl(this.resources);
        HttpResponse response = doRequest(url, parameters, new HashMap<>());

        List<T> castedList = new ArrayList<>();
        List<Map<String, Object>> convertedJsonList = this.converter.stringToMapList(response.body());
        try {
            for (Map<String, Object> map : convertedJsonList) {
                T classInstance = clazz.newInstance();
                classInstance.loadParametersFrom(map);
                castedList.add(classInstance);
            }
            return castedList;
        } catch (Exception e) {
            throw new IncompatibleClass(Messages.INCOMPATIBLE_CLASS_FIELDS_ON_HASH, e);
        }
    }

    private HttpResponse doRequest(String url, CanBecomeKeyValueVariable parameters, Map<String, String> headers) throws IOException {
        HttpResponse response;
        String builtParameters;
        switch (this.action){
            case POST:
            case DELETE:
            case PUT:
                builtParameters = parameters.toJson();
                break;

            default:
                builtParameters = parameters.toQueryString();
                break;
        }
        response = this.client.post(url, builtParameters, headers);
        return response;
    }

    private String buildUrl(Stack<String> resources) {
        StringBuilder urlBuilder = new StringBuilder();
        while(!resources.empty()) {
            String resource = resources.pop();
            urlBuilder.append("/");
            urlBuilder.append(resource);
        }
        return urlBuilder.toString();
    }

    private enum Action {
        POST, GET, PUT, DELETE
    }

}

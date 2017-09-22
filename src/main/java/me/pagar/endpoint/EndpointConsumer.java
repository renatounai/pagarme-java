package me.pagar.endpoint;

import me.pagar.ApiClient;
import me.pagar.exception.ApiErrors;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.CanBecomeKeyValueVariable;
import me.pagar.objecttraits.CanBecomeQueryString;
import me.pagar.objecttraits.ResourceObject;
import me.pagar.resource.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

/**
 * Resolves endpoint building and calling
 * Resolves possible parsings
 */
public class EndpointConsumer {

    private ApiClient client;
    private Action action = Action.GET;
    private Stack<String> resources;

    //initial configs
    public EndpointConsumer(ApiClient client) {
        this.client = client;
        resources = new Stack<>();
    }

    /**
     * Set action.
     * Resolves urls ending with special ending actions - calculate_installments, refund, collect_payment, etc
     */
    public EndpointConsumer create() {
        return setActionAndReturnThis(Action.POST);
    }

    public EndpointConsumer delete() {
        return setActionAndReturnThis(Action.DELETE);
    }

    public EndpointConsumer update() {
        return setActionAndReturnThis(Action.PUT);
    }

    public EndpointConsumer post(String action) {
        this.resources.push(action);
        return setActionAndReturnThis(Action.POST);
    }

    public EndpointConsumer find(String id) {
        this.resources.add(id);
        return setActionAndReturnThis(Action.GET);
    }

    public EndpointConsumer find() {
        return setActionAndReturnThis(Action.GET);
    }

    private EndpointConsumer setActionAndReturnThis(Action action) {
        this.action = action;
        return this;
    }

    /**
     * Set intermediary resources. May be id'd ones or not
     */
    public EndpointConsumer of(ApiResources resource) {
        return addResourcesAndReturnThis(resource.getResourceName());
    }

    public EndpointConsumer of(String resource) {
        return addResourcesAndReturnThis(resource);
    }

    public EndpointConsumer of(ApiResources resource, String id) {
        return addResourcesAndReturnThis(resource.getResourceName(), id);
    }

    public EndpointConsumer of(String resource, String id) {
        return addResourcesAndReturnThis(id, resource);
    }

    public EndpointConsumer of(ResourceObject object) {
        return addResourcesAndReturnThis(object.id(), object.object());
    }

    private EndpointConsumer addResourcesAndReturnThis(String... resources) {
        for (String resource : resources) {
            this.resources.push(resource);
        }
        return this;
    }

    /**
     * Closes the endpoint construction and sends the request with parameters
     */
    public <T extends FieldsOnHash> T withParameters(CanBecomeQueryString parameters) throws IOException, ApiErrors {
        StringBuilder urlBuilder = new StringBuilder();
        for (String resource : resources) {
            urlBuilder.append("/");
            urlBuilder.append(resource);
        }
        String url = urlBuilder.toString();

        HttpResponse response;
        switch (this.action){
            case GET:
                response = this.client.get(url, parameters.toQueryString(), new HashMap<>());
                break;

            case PUT:
                response = this.client.put(url, parameters.toQueryString(), new HashMap<>());
                break;

            case POST:
                response = this.client.post(url, parameters.toQueryString(), new HashMap<>());
                break;

            case DELETE:
                response = this.client.delete(url, parameters.toQueryString(), new HashMap<>());
                break;

            default:
                break;
        }
        return null;
    }

    public <T extends FieldsOnHash> T withParameters(CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        StringBuilder urlBuilder = new StringBuilder();
        for (String resource : resources) {
            urlBuilder.append("/");
            urlBuilder.append(resource);
        }
        String url = urlBuilder.toString();

        HttpResponse response;
        switch (this.action){
            case GET:
                response = this.client.get(url, parameters.toJson(), new HashMap<>());
                break;

            case PUT:
                response = this.client.put(url, parameters.toJson(), new HashMap<>());
                break;

            case POST:
                response = this.client.post(url, parameters.toJson(), new HashMap<>());
                break;

            case DELETE:
                response = this.client.delete(url, parameters.toJson(), new HashMap<>());
                break;

            default:
                break;
        }
        return null;
    }

    public <T extends FieldsOnHash> T withNoParameters() throws IOException, ApiErrors {

        String url = buildUrl(this.resources);

        HttpResponse response;
        switch (this.action){
            case GET:
                response = this.client.get(url, "", new HashMap<>());
                break;

            case PUT:
                response = this.client.put(url, "", new HashMap<>());
                break;

            case POST:
                response = this.client.post(url, "", new HashMap<>());
                break;

            case DELETE:
                response = this.client.delete(url, "", new HashMap<>());
                break;

            default:
                break;
        }
        return null;
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

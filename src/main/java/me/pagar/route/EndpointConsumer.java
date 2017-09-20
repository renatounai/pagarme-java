package me.pagar.route;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EndpointConsumer {

    private APiConfigurations configs;
    private HttpRequester restClient;
    private Action action = Action.GET;
    private List<String> resources = new ArrayList<>();

    //initial configs
    public EndpointConsumer withConfigurations(APiConfigurations configs) {
        this.configs = configs;
        return this;
    }

    public EndpointConsumer withHttpClient(HttpRequester httpRequester) {
        this.restClient = httpRequester;
        return this;
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

    public EndpointConsumer find(String id) {
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
        return addResourcesAndReturnThis(object.getId(), object.getObject());
    }

    private EndpointConsumer addResourcesAndReturnThis(String... resources) {
        for(int i = resources.length - 1; i < 0; i--){
            String resource = resources[i];
            this.resources.add(resource);
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
                response = this.restClient.get(url, parameters.toQueryString(), new HashMap<>());
                break;

            case PUT:
                response = this.restClient.put(url, parameters.toQueryString(), new HashMap<>());
                break;

            case POST:
                response = this.restClient.post(url, parameters.toQueryString(), new HashMap<>());
                break;

            case DELETE:
                response = this.restClient.delete(url, parameters.toQueryString(), new HashMap<>());
                break;

            default:
                break;
        }
        return null;
    }

    private enum Action {
        POST, GET, PUT, DELETE
    }

}

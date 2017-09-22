package me.pagar.router;

import me.pagar.APiConfigurations;
import me.pagar.ApiClient;
import me.pagar.exception.ApiErrors;
import me.pagar.endpoint.ApiResources;
import me.pagar.endpoint.EndpointConsumer;
import me.pagar.objecttraits.CanBecomeKeyValueVariable;
import me.pagar.objecttraits.CanBecomeQueryString;
import me.pagar.objecttraits.ResourceObject;

import java.io.IOException;

/**
 * Existing routes sugar
 */
public class TransactionRouter {

    private ApiClient client;

    public TransactionRouter(ApiClient client) {
        this.client = client;
    }

    public TransactionRouter(APiConfigurations configs) {
        this.client = new ApiClient(configs);
    }

    public Object create(CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        return new EndpointConsumer(client)
            .create()
            .of(ApiResources.TRANSACTIONS)
            .withParameters(parameters);
    }

    public Object find() throws IOException, ApiErrors {
        return new EndpointConsumer(client)
            .find()
            .of(ApiResources.TRANSACTIONS)
            .withNoParameters();
    }

    public Object find(CanBecomeQueryString... parameters) throws IOException, ApiErrors {
        return new EndpointConsumer(client)
            .find()
            .of(ApiResources.TRANSACTIONS)
            .withParameters(parameters[0]);
    }

    public Object findById(String id) throws IOException, ApiErrors {
        return new EndpointConsumer(client)
            .find(id)
            .of(ApiResources.TRANSACTIONS)
            .withNoParameters();

    }

    public Object findById(ResourceObject resource) throws IOException, ApiErrors {
        return findById(resource.id());

    }

    public Object refund(String id, CanBecomeKeyValueVariable... parameters) throws IOException, ApiErrors {
        return new EndpointConsumer(client)
            .post("refund")
            .of(ApiResources.TRANSACTIONS, id)
            .withNoParameters();
    }

    public Object refund(ResourceObject resource, CanBecomeKeyValueVariable... parameters) throws IOException, ApiErrors {
        return refund(resource.id());
    }

}

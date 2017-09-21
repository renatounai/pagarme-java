package me.pagar.router;

import me.pagar.APiConfigurations;
import me.pagar.ApiClient;
import me.pagar.ApiErrors;
import me.pagar.FieldsOnHash;
import me.pagar.endpoint.ApiResources;
import me.pagar.endpoint.EndpointConsumer;
import me.pagar.object.CanBecomeKeyValueVariable;
import me.pagar.object.CanBecomeQueryString;

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
}

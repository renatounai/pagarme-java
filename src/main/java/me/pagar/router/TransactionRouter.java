package me.pagar.router;

import me.pagar.ApiClient;
import me.pagar.ApiErrors;
import me.pagar.FieldsOnHash;
import me.pagar.endpoint.ApiResources;
import me.pagar.endpoint.EndpointConsumer;
import me.pagar.object.CanBecomeKeyValueVariable;
import me.pagar.object.CanBecomeQueryString;

import java.io.IOException;

public class TransactionRouter {

    private ApiClient client;

    public TransactionRouter(ApiClient client) {
        this.client = client;
    }

    public Object create(CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        return new EndpointConsumer(client)
                .create()
                .of(ApiResources.TRANSACTIONS)
                .withParameters(parameters);
    }

    public Object find(CanBecomeQueryString parameters) throws IOException, ApiErrors {
        return new EndpointConsumer(client)
                .find()
                .of(ApiResources.TRANSACTIONS)
                .withParameters(parameters);
    }

    public Object findById(String id) throws IOException, ApiErrors {
        return new EndpointConsumer(client)
                .find(id)
                .of(ApiResources.TRANSACTIONS)
                .withNoParameters();

    }
}

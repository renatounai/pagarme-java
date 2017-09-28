package me.pagar.router;

import me.pagar.APiConfigurations;
import me.pagar.ApiClient;
import me.pagar.endpoint.ApiResources;
import me.pagar.endpoint.EndpointConsumer;
import me.pagar.exception.ApiErrors;
import me.pagar.objecttraits.CanBecomeKeyValueVariable;
import me.pagar.responseobject.Customer;
import me.pagar.responseobject.Subscription;

import java.io.IOException;
import java.util.List;

public class CustomerRouter {

    private ApiClient client;
    private EndpointConsumer<Customer> baseEndpoint;

    public CustomerRouter(ApiClient client) {
        this.client = client;
        this.baseEndpoint = new EndpointConsumer<Customer>(this.client, Customer.class)
            .thatHas(ApiResources.CUSTOMERS);
    }

    public CustomerRouter(APiConfigurations configs) {
        this(new ApiClient(configs));
    }

    public Customer create(CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        return baseEndpoint
            .create()
            .withParameters(parameters);
    }

    public Customer find() throws IOException, ApiErrors {
        return baseEndpoint
            .find()
            .withNoParameters();
    }

    public List<Customer> find(CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        return baseEndpoint
            .find()
            .listWithParameters(parameters);
    }

    public Customer findById(String id) throws IOException, ApiErrors {
        return baseEndpoint
            .thatHas(id)
            .find()
            .withNoParameters();
    }
}

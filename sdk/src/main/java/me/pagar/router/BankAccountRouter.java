package me.pagar.router;

import me.pagar.APiConfigurations;
import me.pagar.ApiClient;
import me.pagar.endpoint.ApiResources;
import me.pagar.endpoint.EndpointConsumer;
import me.pagar.exception.ApiErrors;
import me.pagar.objecttraits.CanBecomeKeyValueVariable;
import me.pagar.responseobject.BankAccount;
import me.pagar.responseobject.Customer;

import java.io.IOException;
import java.util.List;

public class BankAccountRouter {

    private ApiClient client;
    private EndpointConsumer<BankAccount> baseEndpoint;

    public BankAccountRouter(ApiClient client) {
        this.client = client;
        this.baseEndpoint = new EndpointConsumer<BankAccount>(this.client, BankAccount.class)
            .thatHas(ApiResources.BANK_ACCOUNTS);
    }

    public BankAccountRouter(APiConfigurations configs) {
        this(new ApiClient(configs));
    }

    public BankAccount create(CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        return baseEndpoint
            .create()
            .withParameters(parameters);
    }

    public BankAccount find() throws IOException, ApiErrors {
        return baseEndpoint
            .find()
            .withNoParameters();
    }

    public List<BankAccount> find(CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        return baseEndpoint
            .find()
            .listWithParameters(parameters);
    }

    public BankAccount findById(String id) throws IOException, ApiErrors {
        return baseEndpoint
            .thatHas(id)
            .find()
            .withNoParameters();
    }
}

package me.pagar.router;

import me.pagar.APiConfigurations;
import me.pagar.ApiClient;
import me.pagar.endpoint.TransactionEndpoint;
import me.pagar.exception.ApiErrors;
import me.pagar.exception.IncompatibleClass;
import me.pagar.objecttraits.CanBecomeKeyValueVariable;
import me.pagar.objecttraits.ResourceObject;
import me.pagar.responseobject.Transaction;

import java.io.IOException;
import java.util.List;

/**
 * Existing routes sugar
 */
public class TransactionRouter {

    private ApiClient client;
    private TransactionEndpoint baseEndpoint;

    public TransactionRouter(ApiClient client) {
        this.client = client;
        this.baseEndpoint = new TransactionEndpoint(this.client);
    }

    public TransactionRouter(APiConfigurations configs) {
        this(new ApiClient(configs));
    }

    public Transaction create(CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors, IncompatibleClass {
        return baseEndpoint
            .create()
            .withParameters(parameters);
    }

    public Transaction find() throws IOException, ApiErrors, IncompatibleClass {
        return baseEndpoint
            .find()
            .withNoParameters();
    }

    public List<Transaction> find(CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors, IncompatibleClass {
        return baseEndpoint
            .find()
            .listWithParameters(parameters);
    }

    public Object findById(String id) throws IOException, ApiErrors, IncompatibleClass {
        return baseEndpoint
            .find(id)
            .withNoParameters();

    }

    public Object findById(ResourceObject resource) throws IOException, ApiErrors, IncompatibleClass {
        return findById(resource.id());
    }

    public Object refund(String id, CanBecomeKeyValueVariable... parameters) throws IOException, ApiErrors, IncompatibleClass {
        return baseEndpoint
            .post("refund")
            .of(id)
            .withNoParameters();
    }

    public Object refund(ResourceObject resource, CanBecomeKeyValueVariable... parameters) throws IOException, ApiErrors, IncompatibleClass {
        return refund(resource.id());
    }

}

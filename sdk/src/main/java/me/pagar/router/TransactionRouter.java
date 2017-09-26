package me.pagar.router;

import me.pagar.APiConfigurations;
import me.pagar.ApiClient;
import me.pagar.endpoint.EndpointConsumer;
import me.pagar.exception.ApiErrors;
import me.pagar.objecttraits.CanBecomeKeyValueVariable;
import me.pagar.responseobject.Transaction;

import java.io.IOException;
import java.util.List;

/**
 * Existing routes sugar
 */
public class TransactionRouter {

    private ApiClient client;
    private EndpointConsumer<Transaction> baseEndpoint;

    public TransactionRouter(ApiClient client) {
        this.client = client;
        this.baseEndpoint = new EndpointConsumer<Transaction>(this.client, Transaction.class);
    }

    public TransactionRouter(APiConfigurations configs) {
        this(new ApiClient(configs));
    }

    public Transaction create(CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        Transaction t = baseEndpoint
                .create()
                .withParameters(parameters);
        return
    }

    public Transaction find() throws IOException, ApiErrors {
        return baseEndpoint
            .find()
            .withNoParameters();
    }

    public List<Transaction> find(CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        return baseEndpoint
            .find()
            .listWithParameters(parameters);
    }

    public Transaction findById(String id) throws IOException, ApiErrors {
        return baseEndpoint
            .thatHas(id)
            .find()
            .withNoParameters();

    }

    public Transaction refund(String id, CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        return baseEndpoint
            .thatHas(id)
            .thatHas("refund")
            .post()
            .withParameters(parameters);
    }

    public Transaction capture(String id, CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        return baseEndpoint
            .thatHas(id)
            .thatHas("capture")
            .post()
            .withParameters(parameters);
    }

    public Transaction collectPayment(String id, CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        return baseEndpoint
            .thatHas(id)
            .thatHas("collect_payment")
            .post()
            .withParameters(parameters);
    }

    public Transaction payBoleto(String id, CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        return baseEndpoint
            .thatHas(id)
            .thatHas("collect_payment")
            .update()
            .withParameters(parameters);
    }

}

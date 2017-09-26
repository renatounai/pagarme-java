package me.pagar.endpoint;

import me.pagar.ApiClient;
import me.pagar.resource.GsonConverter;
import me.pagar.resource.JsonConverter;
import me.pagar.responseobject.Transaction;

public class TransactionEndpoint extends EndpointConsumer<Transaction, TransactionEndpoint> {

    public TransactionEndpoint(ApiClient client, JsonConverter converter) {
        super(client, converter, Transaction.class);
        thatHas(ApiResources.TRANSACTIONS);
    }

    public TransactionEndpoint(ApiClient client) {
        super(client, new GsonConverter(), Transaction.class);
        thatHas(ApiResources.TRANSACTIONS);
    }

}

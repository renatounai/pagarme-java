package me.pagar.endpoint;

import me.pagar.ApiClient;
import me.pagar.resource.GsonConverter;
import me.pagar.resource.JsonConverter;
import me.pagar.responseobject.CardHashKey;

public class CardHashKeyEndpoint extends EndpointConsumer<CardHashKey, TransactionEndpoint> {

    public CardHashKeyEndpoint(ApiClient client, JsonConverter converter) {
        super(client, converter, CardHashKey.class);
        thatHas(ApiResources.TRANSACTIONS);
    }

    public CardHashKeyEndpoint(ApiClient client) {
        super(client, new GsonConverter(), CardHashKey.class);
        thatHas(ApiResources.TRANSACTIONS);
    }

}

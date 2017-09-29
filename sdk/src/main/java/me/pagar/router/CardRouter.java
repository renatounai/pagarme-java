package me.pagar.router;

import me.pagar.APiConfigurations;
import me.pagar.ApiClient;
import me.pagar.endpoint.ApiResources;
import me.pagar.endpoint.EndpointConsumer;
import me.pagar.exception.ApiErrors;
import me.pagar.objecttraits.CanBecomeKeyValueVariable;
import me.pagar.responseobject.BankAccount;
import me.pagar.responseobject.Card;

import java.io.IOException;
import java.util.List;

/**
 * Created by henriquekano on 9/29/17.
 */
public class CardRouter {

    private ApiClient client;
    private EndpointConsumer<Card> baseEndpoint;

    public CardRouter(ApiClient client) {
        this.client = client;
        this.baseEndpoint = new EndpointConsumer<Card>(this.client, Card.class)
            .thatHas(ApiResources.CARDS);
    }

    public CardRouter(APiConfigurations configs) {
        this(new ApiClient(configs));
    }

    public Card create(CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        return baseEndpoint
            .create()
            .withParameters(parameters);
    }

    public Card find() throws IOException, ApiErrors {
        return baseEndpoint
            .find()
            .withNoParameters();
    }

    public List<Card> find(CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        return baseEndpoint
            .find()
            .listWithParameters(parameters);
    }

    public Card findById(String id) throws IOException, ApiErrors {
        return baseEndpoint
                .thatHas(id)
            .find()
            .withNoParameters();
    }
}

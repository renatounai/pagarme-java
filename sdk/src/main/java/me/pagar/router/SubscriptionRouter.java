package me.pagar.router;

import me.pagar.APiConfigurations;
import me.pagar.ApiClient;
import me.pagar.endpoint.ApiResources;
import me.pagar.endpoint.EndpointConsumer;
import me.pagar.exception.ApiErrors;
import me.pagar.objecttraits.CanBecomeKeyValueVariable;
import me.pagar.responseobject.Subscription;

import java.io.IOException;
import java.util.List;

public class SubscriptionRouter  {

    private ApiClient client;
    private EndpointConsumer<Subscription> baseEndpoint;

    public SubscriptionRouter(ApiClient client) {
        this.client = client;
        this.baseEndpoint = new EndpointConsumer<Subscription>(this.client, Subscription.class)
            .thatHas(ApiResources.SUBSCRIPTIONS);
    }

    public SubscriptionRouter(APiConfigurations configs) {
        this(new ApiClient(configs));
    }

    public Subscription create(CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        return baseEndpoint
            .create()
            .withParameters(parameters);
    }

    public Subscription find() throws IOException, ApiErrors {
        return baseEndpoint
            .find()
            .withNoParameters();
    }

    public List<Subscription> find(CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        return baseEndpoint
            .find()
            .listWithParameters(parameters);
    }

    public Subscription findById(String id) throws IOException, ApiErrors {
        return baseEndpoint
            .thatHas(id)
            .find()
            .withNoParameters();
    }

    public Subscription update(String id, CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        return baseEndpoint
            .thatHas(id)
            .update()
            .withParameters(parameters);
    }

    public Subscription cancel(String id) throws IOException, ApiErrors {
        return baseEndpoint
            .post()
            .thatHas(id)
            .thatHas("cancel")
            .withNoParameters();
    }

    public Subscription settleCharges(String id, CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        return baseEndpoint
            .post()
            .thatHas(id)
            .thatHas("settle_charge")
            .withParameters(parameters);
    }


}

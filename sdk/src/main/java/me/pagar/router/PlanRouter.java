package me.pagar.router;

import me.pagar.APiConfigurations;
import me.pagar.ApiClient;
import me.pagar.endpoint.ApiResources;
import me.pagar.endpoint.EndpointConsumer;
import me.pagar.exception.ApiErrors;
import me.pagar.objecttraits.CanBecomeKeyValueVariable;
import me.pagar.responseobject.Plan;

import java.io.IOException;
import java.util.List;

public class PlanRouter  {

    private ApiClient client;
    private EndpointConsumer<Plan> baseEndpoint;

    public PlanRouter(ApiClient client) {
        this.client = client;
        this.baseEndpoint = new EndpointConsumer<Plan>(this.client, Plan.class)
            .thatHas(ApiResources.PLANS);
    }

    public PlanRouter(APiConfigurations configs) {
        this(new ApiClient(configs));
    }

    public Plan create(CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        return baseEndpoint
            .create()
            .withParameters(parameters);
    }

    public Plan find() throws IOException, ApiErrors {
        return baseEndpoint
            .find()
            .withNoParameters();
    }

    public List<Plan> find(CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        return baseEndpoint
            .find()
            .listWithParameters(parameters);
    }

    public Plan findById(String id) throws IOException, ApiErrors {
        return baseEndpoint
            .thatHas(id)
            .find()
            .withNoParameters();
    }

    public Plan update(String id, CanBecomeKeyValueVariable parameters) throws IOException, ApiErrors {
        return baseEndpoint
            .thatHas(id)
            .update()
            .withParameters(parameters);
    }

}

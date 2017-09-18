package me.pagar.route;

import lombok.NonNull;

public class ApiClient {

    private HttpRequester httpClient;
    private APiConfigurations configs;

    public ApiClient(HttpRequester requester, @NonNull APiConfigurations configs) {
        this.httpClient = requester;
        this.configs = configs;
    }

    public ApiClient(@NonNull APiConfigurations configs) {
        this.configs = configs;
        this.httpClient = new OkHttpRequester(configs.apiKey, "x");
    }

    public TransactionRoutes transactions() {
        return new TransactionRoutes(httpClient, configs);
    }


}

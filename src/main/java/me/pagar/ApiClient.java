package me.pagar;

import me.pagar.resource.HttpRequester;
import me.pagar.resource.HttpResponse;
import me.pagar.resource.OkHttpRequester;

import java.io.IOException;
import java.util.Map;

/**
 * Resolves api authentication and hostname
 */
public class ApiClient implements HttpRequester {

    private HttpRequester httpClient;
    private APiConfigurations configs;

    public ApiClient(HttpRequester requester, APiConfigurations configs) {
        this.httpClient = requester;
        this.configs = configs;
    }

    public ApiClient(APiConfigurations configs) {
        this.configs = configs;
        this.httpClient = new OkHttpRequester(configs.apiKey, "x");
    }

    @Override
    public HttpResponse get(String path, String parameters, Map<String, String> headers) throws IOException {
        String url = configs.baseUrl + path;
        return this.httpClient.get(url, parameters, headers);
    }

    @Override
    public HttpResponse post(String path, String parameters, Map<String, String> headers) throws IOException {
        String url = configs.baseUrl + path;

        return this.httpClient.post(url, parameters, headers);
    }

    @Override
    public HttpResponse put(String path, String parameters, Map<String, String> headers) throws IOException {
        String url = configs.baseUrl + path;
        return this.httpClient.put(url, parameters, headers);
    }

    @Override
    public HttpResponse delete(String path, String parameters, Map<String, String> headers) throws IOException {
        String url = configs.baseUrl + path;
        return this.httpClient.delete(url, parameters, headers);
    }
}

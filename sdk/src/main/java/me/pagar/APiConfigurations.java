package me.pagar;

import me.pagar.resource.HttpRequester;
import me.pagar.resource.OkHttpRequester;
import okhttp3.OkHttpClient;

public class APiConfigurations {

    public String apiKey = "";
    public String encryptionKey = "";
    public String baseUrl = "https://api.pagar.me/1";

    public HttpRequester httpRequester;

    public APiConfigurations(String apiKey, String encryptionKey, HttpRequester httpRequester) {
        this.apiKey = apiKey;
        this.encryptionKey = encryptionKey;
        this.httpRequester = httpRequester;
    }

    public APiConfigurations(String apiKey, String encryptionKey) {
        this(apiKey, encryptionKey, new OkHttpRequester(new OkHttpClient(), apiKey, "x"));
    }
    
}

package me.pagar;

import me.pagar.resource.HttpRequester;
import me.pagar.resource.OkHttpRequester;
import okhttp3.OkHttpClient;

public class APiConfigurations {

    public String apiKey = "";
    public String encryptionKey = "";
    public String baseUrl = "https://api.pagar.me/1";

    public APiConfigurations(String apiKey, String encryptionKey) {
        this.apiKey = apiKey;
        this.encryptionKey = encryptionKey;
    }
    
}

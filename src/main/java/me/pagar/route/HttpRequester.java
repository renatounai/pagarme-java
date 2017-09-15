package me.pagar.route;

import java.util.Map;

public interface HttpRequester {

    HttpResponse get(String url, String parameters, Map<String, String> headers);
    HttpResponse post(String url, String parameters, Map<String, String> headers);
    HttpResponse put(String url, String parameters, Map<String, String> headers);
    HttpResponse delete(String url, String parameters, Map<String, String> headers);

}

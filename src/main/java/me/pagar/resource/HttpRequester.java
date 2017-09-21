package me.pagar.resource;

import java.io.IOException;
import java.util.Map;

public interface HttpRequester {

    HttpResponse get(String url, String parameters, Map<String, String> headers) throws IOException;
    HttpResponse post(String url, String parameters, Map<String, String> headers) throws IOException;
    HttpResponse put(String url, String parameters, Map<String, String> headers) throws IOException;
    HttpResponse delete(String url, String parameters, Map<String, String> headers) throws IOException;

}

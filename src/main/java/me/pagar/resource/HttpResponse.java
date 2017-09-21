package me.pagar.resource;

import java.util.Map;

public interface HttpResponse {

    String body();
    Map<String, String> headers();
    Integer statusCode();
}

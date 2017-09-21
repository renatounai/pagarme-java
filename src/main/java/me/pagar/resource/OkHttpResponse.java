package me.pagar.resource;

import java.util.Map;

public class OkHttpResponse implements HttpResponse {

    String body;
    Map<String, String> headers;
    Integer statusCode;

    public OkHttpResponse(String body, Map<String, String> headers, Integer statusCode){
        this.body = body;
        this.headers = headers;
        this.statusCode = statusCode;
    }

    @Override
    public String body() {
        return body;
    }

    @Override
    public Map<String, String> headers() {
        return headers;
    }

    @Override
    public Integer statusCode() {
        return statusCode;
    }
}

package me.pagar.exception;

public class ApiErrors extends Exception {

    private Integer statusCode;
    private String url;
    private String method;
    private String body;

    public ApiErrors(Integer statusCode, String url, String method, String body) {
        this.body = body;
        this.method = method;
        this.statusCode = statusCode;
        this.url = url;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }
}

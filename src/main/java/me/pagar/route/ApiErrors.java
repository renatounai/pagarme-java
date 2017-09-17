package me.pagar.route;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiErrors extends Exception {

    private Integer statusCode;
    private String url;
    private String method;
    private String body;

}

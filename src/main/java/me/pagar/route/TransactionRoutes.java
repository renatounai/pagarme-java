package me.pagar.route;

import lombok.AllArgsConstructor;
import me.pagar.route.responseobject.Transaction;

import java.io.IOException;
import java.util.HashMap;

@AllArgsConstructor
public class TransactionRoutes {

    private HttpRequester httpRequester;
    private APiConfigurations configurations;

    public Transaction create(CanBecomeKeyValueVariable parameters) throws ApiErrors, IOException {
        String url = configurations.baseUrl.concat("/schema/response/transactions");
        String jsonString = parameters.toJson();
        HashMap<String, String> headers = new HashMap<String, String>();
        HttpResponse apiResponse = httpRequester.post(url, jsonString, headers);

        Integer statusCode = apiResponse.statusCode();
        String apiResponseBody = apiResponse.body();
        Boolean apiReturnOk = statusCode >= 200 && statusCode <= 299;
        if(apiReturnOk){
            String jsonResponse = apiResponseBody;
            Transaction newTransaction = new Transaction(jsonResponse);
            return newTransaction;
        } else {
            throw new ApiErrors(statusCode, url, "POST", apiResponseBody);
        }
    }
}

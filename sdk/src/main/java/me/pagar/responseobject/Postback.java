package me.pagar.responseobject;

import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class Postback extends FieldsOnHash implements ResourceObject {
    public Postback() {
        super(new HashMap<String, Object>());
    }

    public Postback(Map<String, Object> parameters) {
        super(parameters);
    }

    public Postback(String jsonString) {
        super(jsonString);
    }

    public String dateCreated() {
        return super.getParameterAsString("date_created");
    }

    public String dateUpdated() {
        return super.getParameterAsString("date_updated");
    }

    public List<Delivery> deliveries() {
        return super.getParameterAsObjectList("deliveries", Delivery.class);
    }

    public String headers() {
        return super.getParameterAsString("headers");
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public String model() {
        return super.getParameterAsString("model");
    }

    public String modelId() {
        return super.getParameterAsString("model_id");
    }

    public String nextRetry() {
        return super.getParameterAsString("next_retry");
    }

    public String object() {
        return super.getParameterAsString("object");
    }

    public String payload() {
        return super.getParameterAsString("payload");
    }

    public String requestUrl() {
        return super.getParameterAsString("request_url");
    }

    public Integer retries() {
        return super.getParameterAsInteger("retries");
    }

    public String signature() {
        return super.getParameterAsString("signature");
    }

    public String status() {
        return super.getParameterAsString("status");
    }
}

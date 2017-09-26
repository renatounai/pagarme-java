package me.pagar.responseobject;

import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class Delivery extends FieldsOnHash implements ResourceObject {
    public Delivery() {
        super(new HashMap<String, Object>());
    }

    public Delivery(Map<String, Object> parameters) {
        super(parameters);
    }

    public Delivery(String jsonString) {
        super(jsonString);
    }

    public String dateCreated() {
        return super.getParameterAsString("date_created");
    }

    public String dateUpdated() {
        return super.getParameterAsString("date_updated");
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public String object() {
        return super.getParameterAsString("object");
    }

    public String responseBody() {
        return super.getParameterAsString("response_body");
    }

    public String responseHeaders() {
        return super.getParameterAsString("response_headers");
    }

    public Integer responseTime() {
        return super.getParameterAsInteger("response_time");
    }

    public String status() {
        return super.getParameterAsString("status");
    }

    public String statusCode() {
        return super.getParameterAsString("status_code");
    }

    public String statusReason() {
        return super.getParameterAsString("status_reason");
    }
}

package me.pagar.responseobject;

import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class BulkAnticipation extends FieldsOnHash implements ResourceObject {
    public BulkAnticipation() {
        super(new HashMap<String, Object>());
    }

    public BulkAnticipation(Map<String, Object> parameters) {
        super(parameters);
    }

    public BulkAnticipation(String jsonString) {
        super(jsonString);
    }

    public Integer amount() {
        return super.getParameterAsInteger("amount");
    }

    public Integer anticipationFee() {
        return super.getParameterAsInteger("anticipation_fee");
    }

    public String dateCreated() {
        return super.getParameterAsString("date_created");
    }

    public String dateUpdated() {
        return super.getParameterAsString("date_updated");
    }

    public Integer fee() {
        return super.getParameterAsInteger("fee");
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public String object() {
        return super.getParameterAsString("object");
    }

    public String paymentDate() {
        return super.getParameterAsString("payment_date");
    }

    public String status() {
        return super.getParameterAsString("status");
    }

    public String timeframe() {
        return super.getParameterAsString("timeframe");
    }

    public String type() {
        return super.getParameterAsString("type");
    }
}

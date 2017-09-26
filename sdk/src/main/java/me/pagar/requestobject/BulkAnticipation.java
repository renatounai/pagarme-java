package me.pagar.requestobject;

import java.lang.Boolean;
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

    public String object() {
        return "bulk_anticipation";
    }

    public BulkAnticipation id(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public BulkAnticipation recipientId(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String recipientId() {
        return super.getParameterAsString("recipient_id");
    }

    public BulkAnticipation paymentDate(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String paymentDate() {
        return super.getParameterAsString("payment_date");
    }

    public BulkAnticipation timeframe(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String timeframe() {
        return super.getParameterAsString("timeframe");
    }

    public BulkAnticipation requestedAmount(String parameterName, Integer parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Integer requestedAmount() {
        return super.getParameterAsInteger("requested_amount");
    }

    public BulkAnticipation build(String parameterName, Boolean parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Boolean build() {
        return super.getParameterAsBoolean("build");
    }
}

package me.pagar.requestobject;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class SplitRule extends FieldsOnHash implements ResourceObject {
    public SplitRule() {
        super(new HashMap<String, Object>());
    }

    public SplitRule(Map<String, Object> parameters) {
        super(parameters);
    }

    public SplitRule(String jsonString) {
        super(jsonString);
    }

    public String object() {
        return "split_rule";
    }

    public SplitRule id(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public SplitRule liable(String parameterName, Boolean parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Boolean liable() {
        return super.getParameterAsBoolean("liable");
    }

    public SplitRule amount(String parameterName, Integer parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Integer amount() {
        return super.getParameterAsInteger("amount");
    }

    public SplitRule percentage(String parameterName, Integer parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Integer percentage() {
        return super.getParameterAsInteger("percentage");
    }

    public SplitRule recipientId(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String recipientId() {
        return super.getParameterAsString("recipient_id");
    }

    public SplitRule chargeRemainder(String parameterName, Boolean parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Boolean chargeRemainder() {
        return super.getParameterAsBoolean("charge_remainder");
    }

    public SplitRule chargeProcessingFee(String parameterName, Boolean parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Boolean chargeProcessingFee() {
        return super.getParameterAsBoolean("charge_processing_fee");
    }
}

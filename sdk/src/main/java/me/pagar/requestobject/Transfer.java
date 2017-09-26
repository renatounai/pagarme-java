package me.pagar.requestobject;

import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class Transfer extends FieldsOnHash implements ResourceObject {
    public Transfer() {
        super(new HashMap<String, Object>());
    }

    public Transfer(Map<String, Object> parameters) {
        super(parameters);
    }

    public Transfer(String jsonString) {
        super(jsonString);
    }

    public String object() {
        return "transfer";
    }

    public Transfer id(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public Transfer amount(String parameterName, Integer parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Integer amount() {
        return super.getParameterAsInteger("amount");
    }

    public Transfer type(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String type() {
        return super.getParameterAsString("type");
    }

    public Transfer bankAccountId(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String bankAccountId() {
        return super.getParameterAsString("bank_account_id");
    }

    public Transfer metadata(String parameterName, Map<String, Object> parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Map<String, Object> metadata() {
        return super.getParameterAsMap("metadata");
    }

    public Transfer recipientId(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String recipientId() {
        return super.getParameterAsString("recipient_id");
    }
}

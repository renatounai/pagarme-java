package me.pagar.requestobject;

import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class Card extends FieldsOnHash implements ResourceObject {
    public Card() {
        super(new HashMap<String, Object>());
    }

    public Card(Map<String, Object> parameters) {
        super(parameters);
    }

    public Card(String jsonString) {
        super(jsonString);
    }

    public String object() {
        return "card";
    }

    public Card id(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public Card holderName(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String holderName() {
        return super.getParameterAsString("holder_name");
    }

    public Card expirationDate(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String expirationDate() {
        return super.getParameterAsString("expiration_date");
    }

    public Card cvv(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String cvv() {
        return super.getParameterAsString("cvv");
    }

    public Card number(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String number() {
        return super.getParameterAsString("number");
    }

    public Card customerId(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String customerId() {
        return super.getParameterAsString("customer_id");
    }
}

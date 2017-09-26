package me.pagar.requestobject;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class Shipping extends FieldsOnHash implements ResourceObject {
    public Shipping() {
        super(new HashMap<String, Object>());
    }

    public Shipping(Map<String, Object> parameters) {
        super(parameters);
    }

    public Shipping(String jsonString) {
        super(jsonString);
    }

    public String object() {
        return "shipping";
    }

    public Shipping id(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public Shipping address(String parameterName, Address parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Address address() {
        return super.getParameterCasted("address", new Address());
    }

    public Shipping name(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String name() {
        return super.getParameterAsString("name");
    }

    public Shipping fee(String parameterName, Integer parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Integer fee() {
        return super.getParameterAsInteger("fee");
    }

    public Shipping deliveryDate(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String deliveryDate() {
        return super.getParameterAsString("delivery_date");
    }

    public Shipping expedited(String parameterName, Boolean parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Boolean expedited() {
        return super.getParameterAsBoolean("expedited");
    }
}

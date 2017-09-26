package me.pagar.requestobject;

import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class Billing extends FieldsOnHash implements ResourceObject {
    public Billing() {
        super(new HashMap<String, Object>());
    }

    public Billing(Map<String, Object> parameters) {
        super(parameters);
    }

    public Billing(String jsonString) {
        super(jsonString);
    }

    public String object() {
        return "billing";
    }

    public Billing id(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public Billing address(String parameterName, Address parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Address address() {
        return super.getParameterCasted("address", new Address());
    }

    public Billing name(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String name() {
        return super.getParameterAsString("name");
    }
}

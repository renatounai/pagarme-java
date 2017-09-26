package me.pagar.requestobject;

import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class Address extends FieldsOnHash implements ResourceObject {
    public Address() {
        super(new HashMap<String, Object>());
    }

    public Address(Map<String, Object> parameters) {
        super(parameters);
    }

    public Address(String jsonString) {
        super(jsonString);
    }

    public String object() {
        return "address";
    }

    public Address id(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public Address street(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String street() {
        return super.getParameterAsString("street");
    }

    public Address streetNumber(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String streetNumber() {
        return super.getParameterAsString("street_number");
    }

    public Address neighborhood(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String neighborhood() {
        return super.getParameterAsString("neighborhood");
    }

    public Address city(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String city() {
        return super.getParameterAsString("city");
    }

    public Address state(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String state() {
        return super.getParameterAsString("state");
    }

    public Address zipcode(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String zipcode() {
        return super.getParameterAsString("zipcode");
    }

    public Address country(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String country() {
        return super.getParameterAsString("country");
    }

    public Address complementary(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String complementary() {
        return super.getParameterAsString("complementary");
    }
}

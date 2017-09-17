package me.pagar.route.requestobject;

import me.pagar.route.FieldsOnHash;

import java.util.HashMap;
import java.util.Map;

public class Address extends FieldsOnHash{

    public Address() {
        super(new HashMap<String, Object>());
    }

    public Address(Map<String, Object> parameters) {
        super(parameters);
    }

    public Address(String jsonString) {
        super(jsonString);
    }

    public String getCountry() {
        return super.getParameterAsString("country");
    }

    public Address country(String country) {
        super.setParameter("country", country);
        return this;
    }

    public String state() {
        return super.getParameterAsString("state");
    }

    public Address state(String state) {
        super.setParameter("state", state);
        return this;
    }

    public String city() {
        return super.getParameterAsString("city");
    }

    public Address city(String city) {
        super.setParameter("city", city);
        return this;
    }

    public String neighborhood() {
        return super.getParameterAsString("neighborhood");
    }

    public Address neighborhood(String neighborhood) {
        super.setParameter("neighborhood", neighborhood);
        return this;
    }

    public String street() {
        return super.getParameterAsString("street");
    }

    public Address street(String street) {
        super.setParameter("street", street);
        return this;
    }

    public String streetNumber() {
        return super.getParameterAsString("street_number");
    }

    public Address streetNumber(String streetNumber) {
        super.setParameter("street_number", streetNumber);
        return this;
    }

    public String zipcode() {
        return super.getParameterAsString("zipcode");
    }

    public Address zipcode(String zipcode) {
        super.setParameter("zipcode", zipcode);
        return this;
    }

}
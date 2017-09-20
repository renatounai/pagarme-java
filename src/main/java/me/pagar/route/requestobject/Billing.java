package me.pagar.route.requestobject;

import me.pagar.route.FieldsOnHash;

import java.util.HashMap;
import java.util.Map;

public class Billing extends FieldsOnHash {

    public Billing() {
        super(new HashMap<String, Object>());
    }

    public Billing(Map<String, Object> parameters) {
        super(parameters);
    }

    public Billing(String jsonString) {
        super(jsonString);
    }

    public String getName() {
        return super.getParameterAsString("name");
    }

    public Billing setName(String name) {
        super.setParameter("name", name);
        return this;
    }

    public Address getAddress() {
        try {
            return super.getParameterCasted("schema/response/address", new Address());
        } catch (Exception e) {
            return null;
        }
    }

    public Billing setAddress(Address address) {
        super.setParameter("schema/response/address", address);
        return this;
    }

}

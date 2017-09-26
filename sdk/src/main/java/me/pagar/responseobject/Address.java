package me.pagar.responseobject;

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
        return super.getParameterAsString("object");
    }

    public String street() {
        return super.getParameterAsString("street");
    }

    public String complementary() {
        return super.getParameterAsString("complementary");
    }

    public String streetNumber() {
        return super.getParameterAsString("street_number");
    }

    public String neighborhood() {
        return super.getParameterAsString("neighborhood");
    }

    public String city() {
        return super.getParameterAsString("city");
    }

    public String state() {
        return super.getParameterAsString("state");
    }

    public String zipcode() {
        return super.getParameterAsString("zipcode");
    }

    public String country() {
        return super.getParameterAsString("country");
    }

    public String id() {
        return super.getParameterAsString("id");
    }
}

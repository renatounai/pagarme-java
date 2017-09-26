package me.pagar.responseobject;

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

    public Address address() {
        return super.getParameterCasted("address", new Address());
    }

    public String object() {
        return super.getParameterAsString("object");
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public String name() {
        return super.getParameterAsString("name");
    }
}

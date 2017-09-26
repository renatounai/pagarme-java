package me.pagar.responseobject;

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

    public Integer fee() {
        return super.getParameterAsInteger("fee");
    }

    public String deliveryDate() {
        return super.getParameterAsString("delivery_date");
    }

    public Boolean expedited() {
        return super.getParameterAsBoolean("expedited");
    }
}

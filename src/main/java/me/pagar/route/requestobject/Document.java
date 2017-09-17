package me.pagar.route.requestobject;

import me.pagar.route.FieldsOnHash;

import java.util.HashMap;
import java.util.Map;

public class Document extends FieldsOnHash{

    public Document() {
        super(new HashMap<String, Object>());
    }

    public Document(Map<String, Object> parameters) {
        super(parameters);
    }

    public Document(String jsonString) {
        super(jsonString);
    }

    public String getType() {
        return super.getParameterAsString("type");
    }

    public Document setType(String type) {
        super.setParameter("type", type);
        return this;
    }

    public String getNumber() {
        return super.getParameterAsString("number");
    }

    public Document setNumber(String number) {
        super.setParameter("number", number);
        return this;
    }

}

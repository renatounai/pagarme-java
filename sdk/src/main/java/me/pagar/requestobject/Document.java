package me.pagar.requestobject;

import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class Document extends FieldsOnHash implements ResourceObject {
    public Document() {
        super(new HashMap<String, Object>());
    }

    public Document(Map<String, Object> parameters) {
        super(parameters);
    }

    public Document(String jsonString) {
        super(jsonString);
    }

    public String object() {
        return "document";
    }

    public Document id(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public Document type(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String type() {
        return super.getParameterAsString("type");
    }

    public Document number(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String number() {
        return super.getParameterAsString("number");
    }
}

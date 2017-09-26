package me.pagar.responseobject;

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
        return super.getParameterAsString("object");
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public String type() {
        return super.getParameterAsString("type");
    }

    public String number() {
        return super.getParameterAsString("number");
    }
}

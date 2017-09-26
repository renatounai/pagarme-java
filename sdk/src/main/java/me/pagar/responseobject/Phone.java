package me.pagar.responseobject;

import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class Phone extends FieldsOnHash implements ResourceObject {
    public Phone() {
        super(new HashMap<String, Object>());
    }

    public Phone(Map<String, Object> parameters) {
        super(parameters);
    }

    public Phone(String jsonString) {
        super(jsonString);
    }

    public String object() {
        return super.getParameterAsString("object");
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public String ddd() {
        return super.getParameterAsString("ddd");
    }

    public String ddi() {
        return super.getParameterAsString("ddi");
    }

    public String number() {
        return super.getParameterAsString("number");
    }
}

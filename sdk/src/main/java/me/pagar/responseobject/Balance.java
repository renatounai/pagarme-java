package me.pagar.responseobject;

import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class Balance extends FieldsOnHash {
    public Balance() {
        super(new HashMap<String, Object>());
    }

    public Balance(Map<String, Object> parameters) {
        super(parameters);
    }

    public Balance(String jsonString) {
        super(jsonString);
    }

    public Integer amount() {
        return super.getParameterAsInteger("amount");
    }
}

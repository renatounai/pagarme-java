package me.pagar.responseobject;

import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class CardHashKey extends FieldsOnHash {
    public CardHashKey() {
        super(new HashMap<String, Object>());
    }

    public CardHashKey(Map<String, Object> parameters) {
        super(parameters);
    }

    public CardHashKey(String jsonString) {
        super(jsonString);
    }

    public String dateCreated() {
        return super.getParameterAsString("date_created");
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public String ip() {
        return super.getParameterAsString("ip");
    }

    public String publicKey() {
        return super.getParameterAsString("public_key");
    }
}

package me.pagar.responseobject;

import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class AnticipationLimits extends FieldsOnHash {
    public AnticipationLimits() {
        super(new HashMap<String, Object>());
    }

    public AnticipationLimits(Map<String, Object> parameters) {
        super(parameters);
    }

    public AnticipationLimits(String jsonString) {
        super(jsonString);
    }

    public AnticipationLimit maximum() {
        return super.getParameterCasted("maximum", new AnticipationLimit());
    }

    public AnticipationLimit minimum() {
        return super.getParameterCasted("minimum", new AnticipationLimit());
    }
}

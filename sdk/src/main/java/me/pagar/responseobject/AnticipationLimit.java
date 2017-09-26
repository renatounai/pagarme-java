package me.pagar.responseobject;

import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class AnticipationLimit extends FieldsOnHash {
    public AnticipationLimit() {
        super(new HashMap<String, Object>());
    }

    public AnticipationLimit(Map<String, Object> parameters) {
        super(parameters);
    }

    public AnticipationLimit(String jsonString) {
        super(jsonString);
    }

    public Integer amount() {
        return super.getParameterAsInteger("amount");
    }

    public Integer anticipationFee() {
        return super.getParameterAsInteger("anticipation_fee");
    }

    public Integer fee() {
        return super.getParameterAsInteger("fee");
    }
}

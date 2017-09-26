package me.pagar.responseobject;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class SplitRule extends FieldsOnHash implements ResourceObject {
    public SplitRule() {
        super(new HashMap<String, Object>());
    }

    public SplitRule(Map<String, Object> parameters) {
        super(parameters);
    }

    public SplitRule(String jsonString) {
        super(jsonString);
    }

    public String object() {
        return super.getParameterAsString("object");
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public Boolean liable() {
        return super.getParameterAsBoolean("liable");
    }

    public Integer amount() {
        return super.getParameterAsInteger("amount");
    }

    public Integer percentage() {
        return super.getParameterAsInteger("percentage");
    }

    public String recipientId() {
        return super.getParameterAsString("recipient_id");
    }

    public Boolean chargeRemainder() {
        return super.getParameterAsBoolean("charge_remainder");
    }

    public Boolean chargeProcessingFee() {
        return super.getParameterAsBoolean("charge_processing_fee");
    }

    public String dateCreated() {
        return super.getParameterAsString("date_created");
    }

    public String dateUpdated() {
        return super.getParameterAsString("date_updated");
    }
}

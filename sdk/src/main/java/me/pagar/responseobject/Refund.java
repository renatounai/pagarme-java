package me.pagar.responseobject;

import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class Refund extends FieldsOnHash implements ResourceObject {
    public Refund() {
        super(new HashMap<String, Object>());
    }

    public Refund(Map<String, Object> parameters) {
        super(parameters);
    }

    public Refund(String jsonString) {
        super(jsonString);
    }

    public String object() {
        return super.getParameterAsString("object");
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public Integer amount() {
        return super.getParameterAsInteger("amount");
    }

    public String type() {
        return super.getParameterAsString("type");
    }

    public String status() {
        return super.getParameterAsString("status");
    }

    public String chargeFeeRecipientId() {
        return super.getParameterAsString("charge_fee_recipient_id");
    }

    public String bankAccountId() {
        return super.getParameterAsString("bank_account_id");
    }

    public String transactionId() {
        return super.getParameterAsString("transaction_id");
    }

    public String dateCreated() {
        return super.getParameterAsString("date_created");
    }

    public Map<String, Object> metadata() {
        return super.getParameterAsMap("metadata");
    }
}

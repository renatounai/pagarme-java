package me.pagar.responseobject;

import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class Transfer extends FieldsOnHash implements ResourceObject {
    public Transfer() {
        super(new HashMap<String, Object>());
    }

    public Transfer(Map<String, Object> parameters) {
        super(parameters);
    }

    public Transfer(String jsonString) {
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

    public String sourceType() {
        return super.getParameterAsString("source_type");
    }

    public String sourceId() {
        return super.getParameterAsString("source_id");
    }

    public String targetType() {
        return super.getParameterAsString("target_type");
    }

    public String targetId() {
        return super.getParameterAsString("target_id");
    }

    public Integer fee() {
        return super.getParameterAsInteger("fee");
    }

    public String fundingDate() {
        return super.getParameterAsString("funding_date");
    }

    public String fundingEstimatedDate() {
        return super.getParameterAsString("funding_estimated_date");
    }

    public String transactionId() {
        return super.getParameterAsString("transaction_id");
    }

    public String dateCreated() {
        return super.getParameterAsString("date_created");
    }

    public BankAccount bankAccount() {
        return super.getParameterCasted("bank_account", new BankAccount());
    }

    public Map<String, Object> metadata() {
        return super.getParameterAsMap("metadata");
    }
}

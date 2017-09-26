package me.pagar.responseobject;

import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class Payable extends FieldsOnHash implements ResourceObject {
    public Payable() {
        super(new HashMap<String, Object>());
    }

    public Payable(Map<String, Object> parameters) {
        super(parameters);
    }

    public Payable(String jsonString) {
        super(jsonString);
    }

    public String object() {
        return super.getParameterAsString("object");
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public String status() {
        return super.getParameterAsString("status");
    }

    public Integer amount() {
        return super.getParameterAsInteger("amount");
    }

    public Integer fee() {
        return super.getParameterAsInteger("fee");
    }

    public Integer anticipationFee() {
        return super.getParameterAsInteger("anticipation_fee");
    }

    public Integer installment() {
        return super.getParameterAsInteger("installment");
    }

    public String transactionId() {
        return super.getParameterAsString("transaction_id");
    }

    public String splitRuleId() {
        return super.getParameterAsString("split_rule_id");
    }

    public String bulkAnticipationId() {
        return super.getParameterAsString("bulk_anticipation_id");
    }

    public String recipientId() {
        return super.getParameterAsString("recipient_id");
    }

    public String paymentDate() {
        return super.getParameterAsString("payment_date");
    }

    public String originalPaymentDate() {
        return super.getParameterAsString("original_payment_date");
    }

    public String type() {
        return super.getParameterAsString("type");
    }

    public String paymentMethod() {
        return super.getParameterAsString("payment_method");
    }

    public String accrualDate() {
        return super.getParameterAsString("accrual_date");
    }

    public String dateCreated() {
        return super.getParameterAsString("date_created");
    }
}

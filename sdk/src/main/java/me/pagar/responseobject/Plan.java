package me.pagar.responseobject;

import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class Plan extends FieldsOnHash implements ResourceObject {
    public Plan() {
        super(new HashMap<String, Object>());
    }

    public Plan(Map<String, Object> parameters) {
        super(parameters);
    }

    public Plan(String jsonString) {
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

    public Integer days() {
        return super.getParameterAsInteger("days");
    }

    public String name() {
        return super.getParameterAsString("name");
    }

    public Integer trialDays() {
        return super.getParameterAsInteger("trial_days");
    }

    public String dateCreated() {
        return super.getParameterAsString("date_created");
    }

    public List<String> paymentMethods() {
        return super.getParameterAsStringList("payment_methods");
    }

    public String color() {
        return super.getParameterAsString("color");
    }

    public Integer charges() {
        return super.getParameterAsInteger("charges");
    }

    public Integer installments() {
        return super.getParameterAsInteger("installments");
    }

    public Integer invoiceReminder() {
        return super.getParameterAsInteger("invoice_reminder");
    }
}

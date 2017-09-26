package me.pagar.requestobject;

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
        return "plan";
    }

    public Plan id(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public Plan amount(String parameterName, Integer parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Integer amount() {
        return super.getParameterAsInteger("amount");
    }

    public Plan days(String parameterName, Integer parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Integer days() {
        return super.getParameterAsInteger("days");
    }

    public Plan name(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String name() {
        return super.getParameterAsString("name");
    }

    public Plan trialDays(String parameterName, Integer parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Integer trialDays() {
        return super.getParameterAsInteger("trial_days");
    }

    public Plan paymentMethods(String parameterName, List<String> parameterValue) {
        super.setParameterCollection(parameterName, parameterValue);
        return this;
    }

    public List<String> paymentMethods() {
        return super.getParameterAsStringList("payment_methods");
    }

    public Plan color(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String color() {
        return super.getParameterAsString("color");
    }

    public Plan charges(String parameterName, Integer parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Integer charges() {
        return super.getParameterAsInteger("charges");
    }

    public Plan installments(String parameterName, Integer parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Integer installments() {
        return super.getParameterAsInteger("installments");
    }

    public Plan invoiceReminder(String parameterName, Integer parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Integer invoiceReminder() {
        return super.getParameterAsInteger("invoice_reminder");
    }
}

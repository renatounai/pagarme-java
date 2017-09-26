package me.pagar.requestobject;

import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class Subscription extends FieldsOnHash implements ResourceObject {
    public Subscription() {
        super(new HashMap<String, Object>());
    }

    public Subscription(Map<String, Object> parameters) {
        super(parameters);
    }

    public Subscription(String jsonString) {
        super(jsonString);
    }

    public String object() {
        return "subscription";
    }

    public Subscription id(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public Subscription planId(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String planId() {
        return super.getParameterAsString("plan_id");
    }

    public Subscription cardHash(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String cardHash() {
        return super.getParameterAsString("card_hash");
    }

    public Subscription cardId(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String cardId() {
        return super.getParameterAsString("card_id");
    }

    public Subscription cardNumber(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String cardNumber() {
        return super.getParameterAsString("card_number");
    }

    public Subscription cardCvv(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String cardCvv() {
        return super.getParameterAsString("card_cvv");
    }

    public Subscription cardHolderName(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String cardHolderName() {
        return super.getParameterAsString("card_holder_name");
    }

    public Subscription cardExpirationDate(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String cardExpirationDate() {
        return super.getParameterAsString("card_expiration_date");
    }

    public Subscription postbackUrl(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String postbackUrl() {
        return super.getParameterAsString("postback_url");
    }

    public Subscription customer(String parameterName, Customer parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Customer customer() {
        return super.getParameterCasted("customer", new Customer());
    }

    public Subscription paymentMethod(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String paymentMethod() {
        return super.getParameterAsString("payment_method");
    }

    public Subscription metadata(String parameterName, Map<String, Object> parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Map<String, Object> metadata() {
        return super.getParameterAsMap("metadata");
    }

    public Subscription splitRules(String parameterName, List<SplitRule> parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public List<SplitRule> splitRules() {
        return super.getParameterAsObjectList("split_rules", SplitRule.class);
    }
}

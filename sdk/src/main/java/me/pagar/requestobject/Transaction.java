package me.pagar.requestobject;

import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class Transaction extends FieldsOnHash implements ResourceObject {
    public Transaction() {
        super(new HashMap<String, Object>());
    }

    public Transaction(Map<String, Object> parameters) {
        super(parameters);
    }

    public Transaction(String jsonString) {
        super(jsonString);
    }

    public String object() {
        return "transaction";
    }

    public Transaction id(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public Transaction amount(String parameterName, Integer parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Integer amount() {
        return super.getParameterAsInteger("amount");
    }

    public Transaction cardNumber(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String cardNumber() {
        return super.getParameterAsString("card_number");
    }

    public Transaction cardCvv(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String cardCvv() {
        return super.getParameterAsString("card_cvv");
    }

    public Transaction cardExpirationDate(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String cardExpirationDate() {
        return super.getParameterAsString("card_expiration_date");
    }

    public Transaction cardHolderName(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String cardHolderName() {
        return super.getParameterAsString("card_holder_name");
    }

    public Transaction cardHash(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String cardHash() {
        return super.getParameterAsString("card_hash");
    }

    public Transaction cardId(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String cardId() {
        return super.getParameterAsString("card_id");
    }

    public Transaction customer(String parameterName, Customer parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Customer customer() {
        return super.getParameterCasted("customer", new Customer());
    }

    public Transaction billing(String parameterName, Billing parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Billing billing() {
        return super.getParameterCasted("billing", new Billing());
    }

    public Transaction shipping(String parameterName, Shipping parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Shipping shipping() {
        return super.getParameterCasted("shipping", new Shipping());
    }

    public Transaction items(String parameterName, List<Item> parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public List<Item> items() {
        return super.getParameterAsObjectList("items", Item.class);
    }
}

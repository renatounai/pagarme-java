package me.pagar.route.requestobject;

import me.pagar.route.FieldsOnHash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transaction extends FieldsOnHash {

    public Transaction(){
        super(new HashMap<String, Object>());
    }

    public Transaction(Map<String, Object> parameters){
        super(parameters);
    }

    public Transaction(String jsonString){
        super(jsonString);
    }

    public Integer amount() {
        return super.getParameterAsInteger("amount");
    }

    public Transaction amount(Integer amount) {
        super.setParameter("amount", amount);
        return this;
    }

    public String cardNumber() {
        return super.getParameterAsString("card_number");
    }

    public Transaction cardNumber(String cardNumber) {
        super.setParameter("card_number", cardNumber);
        return this;
    }

    public String cardCvv() {
        return super.getParameterAsString("card_cvv");
    }

    public Transaction cardCvv(String cardCvv) {
        super.setParameter("card_cvv", cardCvv);
        return this;
    }

    public String cardExpirationDate() {
        return super.getParameterAsString("card_expiration_date");
    }

    public Transaction cardExpirationDate(String cardExpirationDate) {
        super.setParameter("card_expiration_date", cardExpirationDate);
        return this;
    }

    public String cardHolderName() {
        return super.getParameterAsString("card_holder_name");
    }

    public Transaction cardHolderName(String cardHolderName) {
        super.setParameter("card_holder_name", cardHolderName);
        return this;
    }

    public Customer customer() {
        try {
            return super.getParameterCasted("customer", new Customer());
        } catch (Exception e) {
            return null;
        }
    }

    public Transaction customer(Customer customer) {
        super.setParameter("customer", customer);
        return this;
    }

    public Billing billing() {
        try {
            return super.getParameterCasted("billing", new Billing());
        } catch (Exception e) {
            return null;
        }
    }

    public Transaction billing(Billing billing) {
        super.setParameter("billing", billing);
        return this;
    }

    public Shipping shipping() {
        try {
            return super.getParameterCasted("shipping", new Shipping());
        } catch (Exception e) {
            return null;
        }
    }

    public Transaction shipping(Shipping shipping) {
        super.setParameter("shipping", shipping);
        return this;
    }

    public List<Item> items() {
        return super.<Item>getParameterAsList("items");
    }

    public Transaction items(List<Item> items) {
        super.setParameter("items", items);
        return this;
    }
}

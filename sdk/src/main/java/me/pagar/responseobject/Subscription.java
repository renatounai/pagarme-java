package me.pagar.responseobject;

import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
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
        return super.getParameterAsString("object");
    }

    public Plan plan() {
        return super.getParameterCasted("plan", new Plan());
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public Transaction currentTransaction() {
        return super.getParameterCasted("current_transaction", new Transaction());
    }

    public String postbackUrl() {
        return super.getParameterAsString("postback_url");
    }

    public String paymentMethod() {
        return super.getParameterAsString("payment_method");
    }

    public String cardBrand() {
        return super.getParameterAsString("card_brand");
    }

    public String cardLastDigits() {
        return super.getParameterAsString("card_last_digits");
    }

    public String currentPeriodStart() {
        return super.getParameterAsString("current_period_start");
    }

    public String currentPeriodEnd() {
        return super.getParameterAsString("current_period_end");
    }

    public Integer charges() {
        return super.getParameterAsInteger("charges");
    }

    public String status() {
        return super.getParameterAsString("status");
    }

    public String dateCreated() {
        return super.getParameterAsString("date_created");
    }

    public String dateUpdated() {
        return super.getParameterAsString("date_updated");
    }

    public Phone phone() {
        return super.getParameterCasted("phone", new Phone());
    }

    public Address address() {
        return super.getParameterCasted("address", new Address());
    }

    public Customer customer() {
        return super.getParameterCasted("customer", new Customer());
    }

    public Card card() {
        return super.getParameterCasted("card", new Card());
    }

    public Map<String, Object> metadata() {
        return super.getParameterAsMap("metadata");
    }

    public Integer settledCharges() {
        return super.getParameterAsInteger("settled_charges");
    }
}

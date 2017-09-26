package me.pagar.responseobject;

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
        return super.getParameterAsString("object");
    }

    public String status() {
        return super.getParameterAsString("status");
    }

    public String refuseReason() {
        return super.getParameterAsString("refuse_reason");
    }

    public String statusReason() {
        return super.getParameterAsString("status_reason");
    }

    public String acquirerResponseCode() {
        return super.getParameterAsString("acquirer_response_code");
    }

    public String acquirerName() {
        return super.getParameterAsString("acquirer_name");
    }

    public String acquirerId() {
        return super.getParameterAsString("acquirer_id");
    }

    public String authorizationCode() {
        return super.getParameterAsString("authorization_code");
    }

    public String softDescriptor() {
        return super.getParameterAsString("soft_descriptor");
    }

    public String tid() {
        return super.getParameterAsString("tid");
    }

    public String nsu() {
        return super.getParameterAsString("nsu");
    }

    public String dateCreated() {
        return super.getParameterAsString("date_created");
    }

    public String dateUpdated() {
        return super.getParameterAsString("date_updated");
    }

    public Integer amount() {
        return super.getParameterAsInteger("amount");
    }

    public Integer authorizedAmount() {
        return super.getParameterAsInteger("authorized_amount");
    }

    public Integer paidAmount() {
        return super.getParameterAsInteger("paid_amount");
    }

    public Integer refundedAmount() {
        return super.getParameterAsInteger("refunded_amount");
    }

    public Integer installments() {
        return super.getParameterAsInteger("installments");
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public Integer cost() {
        return super.getParameterAsInteger("cost");
    }

    public String cardHolderName() {
        return super.getParameterAsString("card_holder_name");
    }

    public String cardLastDigits() {
        return super.getParameterAsString("card_last_digits");
    }

    public String cardFirstDigits() {
        return super.getParameterAsString("card_first_digits");
    }

    public String cardBrand() {
        return super.getParameterAsString("card_brand");
    }

    public String cardPinMode() {
        return super.getParameterAsString("card_pin_mode");
    }

    public String postbackUrl() {
        return super.getParameterAsString("postback_url");
    }

    public String paymentMethod() {
        return super.getParameterAsString("payment_method");
    }

    public String captureMethod() {
        return super.getParameterAsString("capture_method");
    }

    public String antifraudScore() {
        return super.getParameterAsString("antifraud_score");
    }

    public String boletoUrl() {
        return super.getParameterAsString("boleto_url");
    }

    public String boletoBarcode() {
        return super.getParameterAsString("boleto_barcode");
    }

    public String boletoExpirationDate() {
        return super.getParameterAsString("boleto_expiration_date");
    }

    public String referer() {
        return super.getParameterAsString("referer");
    }

    public String ip() {
        return super.getParameterAsString("ip");
    }

    public String subscriptionId() {
        return super.getParameterAsString("subscription_id");
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

    public Billing billing() {
        return super.getParameterCasted("billing", new Billing());
    }

    public Shipping shipping() {
        return super.getParameterCasted("shipping", new Shipping());
    }

    public List<Item> items() {
        return super.getParameterAsObjectList("items", Item.class);
    }

    public Card card() {
        return super.getParameterCasted("card", new Card());
    }

    public List<SplitRule> splitRules() {
        return super.getParameterAsObjectList("split_rules", SplitRule.class);
    }

    public Map<String, Object> metadata() {
        return super.getParameterAsMap("metadata");
    }

    public Map<String, Object> antifraudMetadata() {
        return super.getParameterAsMap("antifraud_metadata");
    }

    public String referenceKey() {
        return super.getParameterAsString("reference_key");
    }
}

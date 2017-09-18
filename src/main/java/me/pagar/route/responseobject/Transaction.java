package me.pagar.route.responseobject;

import me.pagar.route.FieldsOnHash;

import java.util.HashMap;
import java.util.Map;

public class Transaction extends FieldsOnHash {

    public Transaction() {
        super(new HashMap<>());
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

    public Transaction object(String object) {
        super.setParameter("object", object);
        return this;
    }

    public String status() {
        return super.getParameterAsString("status");
    }

    public Transaction status(String status) {
        super.setParameter("status", status);
        return this;
    }

    public String refuseReason() {
        return super.getParameterAsString("refuse_reason");
    }

    public Transaction refuseReason(String refuseReason) {
        super.setParameter("refuse_reason", refuseReason);
        return this;
    }

    public String statusReason() {
        return super.getParameterAsString("status_reason");
    }

    public Transaction statusReason(String statusReason) {
        super.setParameter("status_reason", statusReason);
        return this;
    }

    public String acquirerResponseCode() {
        return super.getParameterAsString("acquirer_response_code");
    }

    public Transaction acquirerResponseCode(String acquirerResponseCode) {
        super.setParameter("acquirer_response_code", acquirerResponseCode);
        return this;
    }

    public String acquirerName() {
        return super.getParameterAsString("acquirer_name");
    }

    public Transaction acquirerName(String acquirerName) {
        super.setParameter("acquirer_name", acquirerName);
        return this;
    }

    public String acquirerId() {
        return super.getParameterAsString("acquirer_id");
    }

    public Transaction acquirerId(String acquirerId) {
        super.setParameter("acquirer_id", acquirerId);
        return this;
    }

    public String authorizationCode() {
        return super.getParameterAsString("authorization_code");
    }

    public Transaction authorizationCode(String authorizationCode) {
        super.setParameter("authorization_code", authorizationCode);
        return this;
    }

    public String softDescriptor() {
        return super.getParameterAsString("soft_descriptor");
    }

    public Transaction softDescriptor(String softDescriptor) {
        super.setParameter("soft_descriptor", softDescriptor);
        return this;
    }

    public Integer tid() {
        return super.getParameterAsInteger("tid");
    }

    public Transaction tid(Integer tid) {
        super.setParameter("tid", tid);
        return this;
    }

    public Integer nsu() {
        return super.getParameterAsInteger("nsu");
    }

    public Transaction nsu(Integer nsu) {
        super.setParameter("nsu", nsu);
        return this;
    }

    public String dateCreated() {
        return super.getParameterAsString("date_created");
    }

    public Transaction dateCreated(String dateCreated) {
        super.setParameter("date_created", dateCreated);
        return this;
    }

    public String dateUpdated() {
        return super.getParameterAsString("date_updated");
    }

    public Transaction dateUpdated(String dateUpdated) {
        super.setParameter("date_updated", dateUpdated);
        return this;
    }

    public Integer amount() {
        return super.getParameterAsInteger("amount");
    }

    public Transaction amount(Integer amount) {
        super.setParameter("amount", amount);
        return this;
    }

    public Integer authorizedAmount() {
        return super.getParameterAsInteger("authorized_amount");
    }

    public Transaction authorizedAmount(Integer authorizedAmount) {
        super.setParameter("authorized_amount", authorizedAmount);
        return this;
    }

    public Integer paidAmount() {
        return super.getParameterAsInteger("paid_amount");
    }

    public Transaction paidAmount(Integer paidAmount) {
        super.setParameter("paid_amount", paidAmount);
        return this;
    }

    public Integer refundedAmount() {
        return super.getParameterAsInteger("refunded_amount");
    }

    public Transaction refundedAmount(Integer refundedAmount) {
        super.setParameter("refunded_amount", refundedAmount);
        return this;
    }

    public Integer installments() {
        return super.getParameterAsInteger("installments");
    }

    public Transaction installments(Integer installments) {
        super.setParameter("installments", installments);
        return this;
    }

    public Integer id() {
        return super.getParameterAsInteger("id");
    }

    public Transaction id(Integer id) {
        super.setParameter("id", id);
        return this;
    }

    public Integer cost() {
        return super.getParameterAsInteger("cost");
    }

    public Transaction cost(Integer cost) {
        super.setParameter("cost", cost);
        return this;
    }

    public String cardHolderName() {
        return super.getParameterAsString("card_holder_name");
    }

    public Transaction cardHolderName(String cardHolderName) {
        super.setParameter("card_holder_name", cardHolderName);
        return this;
    }

    public String cardLastDigits() {
        return super.getParameterAsString("card_last_digits");
    }

    public Transaction cardLastDigits(String cardLastDigits) {
        super.setParameter("card_last_digits", cardLastDigits);
        return this;
    }

    public String cardFirstDigits() {
        return super.getParameterAsString("card_first_digits");
    }

    public Transaction cardFirstDigits(String cardFirstDigits) {
        super.setParameter("card_first_digits", cardFirstDigits);
        return this;
    }

    public String cardBrand() {
        return super.getParameterAsString("card_brand");
    }

    public Transaction cardBrand(String cardBrand) {
        super.setParameter("card_brand", cardBrand);
        return this;
    }

    public String cardPinMode() {
        return super.getParameterAsString("card_pin_mode");
    }

    public Transaction cardPinMode(String cardPinMode) {
        super.setParameter("card_pin_mode", cardPinMode);
        return this;
    }

    public String postbackUrl() {
        return super.getParameterAsString("postback_url");
    }

    public Transaction postbackUrl(String postbackUrl) {
        super.setParameter("postback_url", postbackUrl);
        return this;
    }

    public String paymentMethod() {
        return super.getParameterAsString("payment_method");
    }

    public Transaction paymentMethod(String paymentMethod) {
        super.setParameter("payment_method", paymentMethod);
        return this;
    }

    public String captureMethod() {
        return super.getParameterAsString("capture_method");
    }

    public Transaction captureMethod(String captureMethod) {
        super.setParameter("capture_method", captureMethod);
        return this;
    }

    public String antifraudScore() {
        return super.getParameterAsString("antifraud_score");
    }

    public Transaction antifraudScore(String antifraudScore) {
        super.setParameter("antifraud_score", antifraudScore);
        return this;
    }

    public String boletoUrl() {
        return super.getParameterAsString("boleto_url");
    }

    public Transaction boletoUrl(String boletoUrl) {
        super.setParameter("boleto_url", boletoUrl);
        return this;
    }

    public String boletoBarcode() {
        return super.getParameterAsString("boleto_barcode");
    }

    public Transaction boletoBarcode(String boletoBarcode) {
        super.setParameter("boleto_barcode", boletoBarcode);
        return this;
    }

    public String boletoExpirationDate() {
        return super.getParameterAsString("boleto_expiration_date");
    }

    public Transaction boletoExpirationDate(String boletoExpirationDate) {
        super.setParameter("boleto_expiration_date", boletoExpirationDate);
        return this;
    }

    public String referer() {
        return super.getParameterAsString("referer");
    }

    public Transaction referer(String referer) {
        super.setParameter("referer", referer);
        return this;
    }

    public String ip() {
        return super.getParameterAsString("ip");
    }

    public Transaction ip(String ip) {
        super.setParameter("ip", ip);
        return this;
    }

    public String subscriptionId() {
        return super.getParameterAsString("subscription_id");
    }

    public Transaction subscriptionId(String subscriptionId) {
        super.setParameter("subscription_id", subscriptionId);
        return this;
    }

    public String phone() {
        return super.getParameterAsString("phone");
    }

    public Transaction phone(String phone) {
        super.setParameter("phone", phone);
        return this;
    }

    public String address() {
        return super.getParameterAsString("schema/response/address");
    }

    public Transaction address(String address) {
        super.setParameter("schema/response/address", address);
        return this;
    }

//    public Customer customer() {
//        return super.getParameterAsString("customer");
//    }
//
//    public Transaction customer(Customer customer) {
//        super.setParameter("customer", customer);
//        return this;
//    }
//
//    public Billing billing() {
//        return super.getParameterAsString("billing");
//    }
//
//    public Transaction billing(Billing billing) {
//        super.setParameter("billing", billing);
//        return this;
//    }
//
//    public Shipping shipping() {
//        return super.getParameterAsString("shipping");
//    }
//
//    public Transaction shipping(Shipping shipping) {
//        super.setParameter("shipping", shipping);
//        return this;
//    }
//
//    public List<Item> items() {
//        return super.getParameterAsString("item");
//    }
//
//    public Transaction items(List<Item> items) {
//        super.setParameter("items", items);
//        return this;
//    }
//
//    public Card card() {
//        return super.getParameterAsString("card");
//    }
//
//    public Transaction card(Card card) {
//        super.setParameter("card", card);
//        return this;
//    }
//
//    public String splitRules() {
//        return super.getParameterAsString("split_rules");
//    }
//
//    public Transaction splitRules(String splitRules) {
//        super.setParameter("split_rules", splitRules);
//        return this;
//    }
//
//    public Metadata metadata() {
//        return super.getParameterAsString("metadata");
//    }
//
//    public Transaction metadata(Metadata metadata) {
//        super.setParameter("metadata", metadata);
//        return this;
//    }
//
//    public AntifraudMetadata antifraudMetadata() {
//        return super.getParameterAsString("antifraud_metadata");
//    }
//
//    public Transaction antifraudMetadata(AntifraudMetadata antifraudMetadata) {
//        super.setParameter("antifraud_metadata", antifraudMetadata);
//        return this;
//    }
//
//    public String referenceKey() {
//        return super.getParameterAsString("reference_key");
//    }
//
//    public Transaction referenceKey(String referenceKey) {
//        super.setParameter("reference_key", referenceKey);
//        return this;
//    }

}

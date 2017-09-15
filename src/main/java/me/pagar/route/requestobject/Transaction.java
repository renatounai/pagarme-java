package me.pagar.route.requestobject;

import me.pagar.model.Customer;
import me.pagar.model.SplitRule;
import me.pagar.route.FieldsOnHash;
import org.joda.time.LocalDate;

import java.util.Collection;
import java.util.HashMap;
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

    public Boolean getAsync() {
        return super.getParameterAsBoolean("async");
    }

    public void setAsync(Boolean async) {
        super.setParameter("async", async);
    }

    public Boolean getCapture() {
        return super.getParameterAsBoolean("capture");
    }

    public void setCapture(Boolean capture) {
        super.setParameter("capture", capture);
    }

    public Integer getAmount() {
        return super.getParameterAsInteger("amount");
    }

    public void setAmount(Integer amount) {
        super.setParameter("amount", amount);
    }

    public Integer getInstallments() {
        return super.getParameterAsInteger("installments");
    }

    public void setInstallments(Integer installments) {
        super.setParameter("installments", installments);
    }

    public String getCardId() {
        return super.getParameterAsString("card_id");
    }

    public void setCardId(String cardId) {
        super.setParameter("card_id", cardId);
    }

    public String getCardNumber() {
        return super.getParameterAsString("card_number");
    }

    public void setCardNumber(String cardNumber) {
        super.setParameter("card_number", cardNumber);
    }

    public String getCardHolderName() {
        return super.getParameterAsString("card_holder_name");
    }

    public void setCardHolderName(String cardHolderName) {
        super.setParameter("card_holder_name", cardHolderName);
    }

    public String getCardExpirationDate() {
        return super.getParameterAsString("card_expiration_date");
    }

    public void setCardExpirationDate(String cardExpirationDate) {
        super.setParameter("card_expiration_date", cardExpirationDate);
    }

    public String getCardCvv() {
        return super.getParameterAsString("card_cvv");
    }

    public void setCardCvv(String cardCvv) {
        super.setParameter("card_cvv", cardCvv);
    }

    public String getCardEmvData() {
        return super.getParameterAsString("card_emv_data");
    }

    public void setCardEmvData(String cardEmvData) {
        super.setParameter("card_emv_data", cardEmvData);
    }

    public String getCardEmvResponse() {
        return super.getParameterAsString("cardEmvResponse");
    }

    public void setCardEmvResponse(String cardEmvResponse) {
        super.setParameter("card_emv_response", cardEmvResponse);
    }

    public String getCardPinMode() {
        return super.getParameterAsString("cardPinMode");
    }

    public void setCardPinMode(String cardPinMode) {
        super.setParameter("card_pin_mode", cardPinMode);
    }

    public String getCardTrack1() {
        return super.getParameterAsString("cardTrack1");
    }

    public void setCardTrack1(String cardTrack1) {
        super.setParameter("card_track_1", cardTrack1);
    }

    public String getCardTrack2() {
        return super.getParameterAsString("card_track_2");
    }

    public void setCardTrack2(String cardTrack2) {
        super.setParameter("card_track_2", cardTrack2);
    }

    public String getCardTrack3() {
        return super.getParameterAsString("card_track_3");
    }

    public void setCardTrack3(String cardTrack3) {
        super.setParameter("card_track_3", cardTrack3);
    }

    public String getCardPin() {
        return super.getParameterAsString("cardPin");
    }

    public void setCardPin(String cardPin) {
        super.setParameter("card_pin", cardPin);
    }

    public String getCardPinKek() {
        return super.getParameterAsString("card_pin_kek");
    }

    public void setCardPinKek(String cardPinKek) {
        super.setParameter("card_pin_kek", cardPinKek);
    }

    public String getSoftDescriptor() {
        return super.getParameterAsString("soft_descriptor");
    }

    public void setSoftDescriptor(String softDescriptor) {
        super.setParameter("soft_descriptor", softDescriptor);
    }

    public String getPostbackUrl() {
        return super.getParameterAsString("postback_url");
    }

    public void setPostbackUrl(String postbackUrl) {
        super.setParameter("postback_url", postbackUrl);
    }

    public String getCardHash() {
        return super.getParameterAsString("card_hash");
    }

    public void setCardHash(String cardHash) {
        super.setParameter("card_hash", cardHash);
    }

    public me.pagar.model.Transaction.CaptureMethod getCaptureMethod() {
        return super.getParameterCasted("payment_method", me.pagar.model.Transaction.CaptureMethod.class);
    }

    public void setCaptureMethod(me.pagar.model.Transaction.CaptureMethod captureMethod) {
        super.setParameter("capture_method", captureMethod);
    }

    public me.pagar.model.Transaction.Status getBoletoExpiration() {
        return super.getParameterAsString("boleto_expiration_date");
    } 

    public me.pagar.model.Transaction.Status setBoletoExpiration(LocalDate boletoExpiration) {
        super.setParameter("boleto_expiration_date", boletoExpiration);
    } 

    public Customer getCustomer() {
        return super.getParameterAsString("customer");
    } 

    public Customer setCustomer(Customer customer) {
        super.setParameter("customer", customer);
    } 

    public Map<String, Object> getMetadata() {
        return super.getParameterAsString("metadata");
    } 

    public Map<String, Object> setMetadata(Map<String, Object> metadata) {
        super.setParameter("metadata", metadata);
    } 

    public Object getAntifraudMetadata() {
        return super.getParameterAsString("antifraud_metadata");
    } 

    public Object setAntifraudMetadata(Object antifraudMetadata) {
        super.setParameter("antifraud_metadata", antifraudMetadata);
    } 

    public Collection<SplitRule> getSplitRules() {
        return super.getParameterAsString("split_rules");
    } 

    public Object setAntifraudMetadata(Collection<SplitRule> splitRules) {
        super.setParameter("split_rules", splitRules);
    } 
}

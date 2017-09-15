package me.pagar.route.responseobject;

import me.pagar.model.*;
import me.pagar.route.FieldsOnHash;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Transaction extends FieldsOnHash {

    public Transaction(String jsonString){
        super(jsonString);
    }

    public Integer getAmount(){
        return super.getParameterAsInteger("amount");
    }

    public Integer getCost() {
        return super.getParameterAsInteger("cost");
    }

    public String getAcquirerResponseCode() {
        return super.getParameterAsString("acquirer_response_code");
    }

    public String getAuthorizationCode() {
        return super.getParameterAsString("authorization_code");
    }

    public String getTid() {
        return super.getParameterAsString("tid");
    }

    public String getNsu() {
        return super.getParameterAsString("nsu");
    }

    public String getPostbackUrl() {
        return super.getParameterAsString("postback_url");
    }

    public String getBoletoUrl() {
        return super.getParameterAsString("boleto_url");
    }

    public String getBoletoBarcode() {
        return super.getParameterAsString("boleto_barcode");
    }

    public String getReferer() {
        return super.getParameterAsString("referer");
    }

    public String getIp() {
        return super.getParameterAsString("ip");
    }

    public me.pagar.model.Transaction.AcquirerName getAcquirerName() {
        return super.getParameterAsString("acquirer_name");
    }

    public me.pagar.model.Transaction.PaymentMethod getPaymentMethod() {
        return super.getParameterAsString("payment_method");
    }

    public me.pagar.model.Transaction.CaptureMethod getCaptureMethod() {
        return super.getParameterAsString("capture_method");
    }

    public me.pagar.model.Transaction.Status getStatus() {
        return super.getParameterAsString("status");
    }

    public me.pagar.model.Transaction.StatusReason getStatusReason() {
        try {
            return super.getParameterAsEnum("status_reason", me.pagar.model.Transaction.StatusReason.class);
        } catch (Exception e) {
            return null;
        }
    }

    public LocalDate getBoletoExpiration() {
        return super.getParameterAsString("boleto_expiration_date");
    }

    public DateTime getDateUpdated() {
        return super.getParameterAsString("date_updated");
    } 

    public Phone getPhone() {
        return super.getParameterAsString("phone", Phone.class);
    }

    public Address getAddress() {
        return super.getParameterAsString("address", Address.class);
    }

    public Customer getCustomer() {
        return super.getParameterAsString("customer", Customer.class);
    }

    public Card getCard() {
        return super.getParameterCasted("card", Card.class);
    }

    public Map<String, Object> getMetadata() {
        return super.getParameterAsMap("metadata");
    }

    public Object getAntifraudMetadata() {
        return super.getParameter("antifraud_metadata");
    }

    public me.pagar.model.Transaction.Event getEvent() {
        return super.getParameterAsString("event");
    }

    public me.pagar.model.Transaction.Status getOldStatus() {
        return super.getParameterAsString("old_status");
    }

    public me.pagar.model.Transaction.Status getCurrentStatus() {
        return super.getParameterAsString("current_status");
    }

    public AntifraudAnalysis.Status getAntifraudMetadata() {
        return super.getParameterAsString("desired_status");
    }

    public String getRefuseReason() {
        return super.getParameterAsString("refuse_reason");
    }

    public Collection<SplitRule> getSplitRule() {
        return super.getParameterAsString("split_rules");
    } 
}

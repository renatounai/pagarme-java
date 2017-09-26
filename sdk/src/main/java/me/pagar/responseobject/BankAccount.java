package me.pagar.responseobject;

import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class BankAccount extends FieldsOnHash implements ResourceObject {
    public BankAccount() {
        super(new HashMap<String, Object>());
    }

    public BankAccount(Map<String, Object> parameters) {
        super(parameters);
    }

    public BankAccount(String jsonString) {
        super(jsonString);
    }

    public String object() {
        return super.getParameterAsString("object");
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public String bankCode() {
        return super.getParameterAsString("bank_code");
    }

    public String agencia() {
        return super.getParameterAsString("agencia");
    }

    public String agenciaDv() {
        return super.getParameterAsString("agencia_dv");
    }

    public String conta() {
        return super.getParameterAsString("conta");
    }

    public String contaDv() {
        return super.getParameterAsString("conta_dv");
    }

    public String type() {
        return super.getParameterAsString("type");
    }

    public String documentType() {
        return super.getParameterAsString("document_type");
    }

    public String documentNumber() {
        return super.getParameterAsString("document_number");
    }

    public String legalName() {
        return super.getParameterAsString("legal_name");
    }

    public Boolean chargeTransferFees() {
        return super.getParameterAsBoolean("charge_transfer_fees");
    }

    public String dateCreated() {
        return super.getParameterAsString("date_created");
    }
}

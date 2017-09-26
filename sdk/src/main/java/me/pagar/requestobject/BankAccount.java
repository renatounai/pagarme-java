package me.pagar.requestobject;

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
        return "bank_account";
    }

    public BankAccount id(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public BankAccount bankCode(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String bankCode() {
        return super.getParameterAsString("bank_code");
    }

    public BankAccount agencia(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String agencia() {
        return super.getParameterAsString("agencia");
    }

    public BankAccount agenciaDv(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String agenciaDv() {
        return super.getParameterAsString("agencia_dv");
    }

    public BankAccount conta(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String conta() {
        return super.getParameterAsString("conta");
    }

    public BankAccount contaDv(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String contaDv() {
        return super.getParameterAsString("conta_dv");
    }

    public BankAccount type(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String type() {
        return super.getParameterAsString("type");
    }

    public BankAccount documentNumber(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String documentNumber() {
        return super.getParameterAsString("document_number");
    }

    public BankAccount legalName(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String legalName() {
        return super.getParameterAsString("legal_name");
    }
}

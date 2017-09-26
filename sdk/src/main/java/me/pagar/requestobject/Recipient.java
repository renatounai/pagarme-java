package me.pagar.requestobject;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class Recipient extends FieldsOnHash implements ResourceObject {
    public Recipient() {
        super(new HashMap<String, Object>());
    }

    public Recipient(Map<String, Object> parameters) {
        super(parameters);
    }

    public Recipient(String jsonString) {
        super(jsonString);
    }

    public String object() {
        return "recipient";
    }

    public Recipient id(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public Recipient transferEnabled(String parameterName, Boolean parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Boolean transferEnabled() {
        return super.getParameterAsBoolean("transfer_enabled");
    }

    public Recipient lastTransfer(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String lastTransfer() {
        return super.getParameterAsString("last_transfer");
    }

    public Recipient transferInterval(String parameterName, Integer parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Integer transferInterval() {
        return super.getParameterAsInteger("transfer_interval");
    }

    public Recipient transferDay(String parameterName, Integer parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Integer transferDay() {
        return super.getParameterAsInteger("transfer_day");
    }

    public Recipient automaticAnticipationEnabled(String parameterName, Boolean parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Boolean automaticAnticipationEnabled() {
        return super.getParameterAsBoolean("automatic_anticipation_enabled");
    }

    public Recipient anticipatableVolumePercentage(String parameterName, Integer parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Integer anticipatableVolumePercentage() {
        return super.getParameterAsInteger("anticipatable_volume_percentage");
    }

    public Recipient bankAccount(String parameterName, BankAccount parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public BankAccount bankAccount() {
        return super.getParameterCasted("bank_account", new BankAccount());
    }

    public Recipient bankAccountId(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String bankAccountId() {
        return super.getParameterAsString("bank_account_id");
    }
}

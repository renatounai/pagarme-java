package me.pagar.responseobject;

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
        return super.getParameterAsString("object");
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public Boolean transferEnabled() {
        return super.getParameterAsBoolean("transfer_enabled");
    }

    public String lastTransfer() {
        return super.getParameterAsString("last_transfer");
    }

    public Integer transferInterval() {
        return super.getParameterAsInteger("transfer_interval");
    }

    public Integer transferDay() {
        return super.getParameterAsInteger("transfer_day");
    }

    public Boolean automaticAnticipationEnabled() {
        return super.getParameterAsBoolean("automatic_anticipation_enabled");
    }

    public Integer anticipatableVolumePercentage() {
        return super.getParameterAsInteger("anticipatable_volume_percentage");
    }

    public String dateCreated() {
        return super.getParameterAsString("date_created");
    }

    public String dateUpdated() {
        return super.getParameterAsString("date_updated");
    }

    public BankAccount bankAccount() {
        return super.getParameterCasted("bank_account", new BankAccount());
    }
}

package me.pagar.responseobject;

import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class Card extends FieldsOnHash implements ResourceObject {
    public Card() {
        super(new HashMap<String, Object>());
    }

    public Card(Map<String, Object> parameters) {
        super(parameters);
    }

    public Card(String jsonString) {
        super(jsonString);
    }

    public String object() {
        return super.getParameterAsString("object");
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public String dateCreated() {
        return super.getParameterAsString("date_created");
    }

    public String dateUpdated() {
        return super.getParameterAsString("date_updated");
    }

    public String brand() {
        return super.getParameterAsString("brand");
    }

    public String holderName() {
        return super.getParameterAsString("holder_name");
    }

    public String firstDigits() {
        return super.getParameterAsString("first_digits");
    }

    public String lastDigits() {
        return super.getParameterAsString("last_digits");
    }

    public String country() {
        return super.getParameterAsString("country");
    }

    public String fingerprint() {
        return super.getParameterAsString("fingerprint");
    }

    public Boolean valid() {
        return super.getParameterAsBoolean("valid");
    }

    public String expirationDate() {
        return super.getParameterAsString("expiration_date");
    }
}

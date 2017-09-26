package me.pagar.responseobject;

import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class Customer extends FieldsOnHash implements ResourceObject {
    public Customer() {
        super(new HashMap<String, Object>());
    }

    public Customer(Map<String, Object> parameters) {
        super(parameters);
    }

    public Customer(String jsonString) {
        super(jsonString);
    }

    public String object() {
        return super.getParameterAsString("object");
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public String externalId() {
        return super.getParameterAsString("external_id");
    }

    public String type() {
        return super.getParameterAsString("type");
    }

    public String country() {
        return super.getParameterAsString("country");
    }

    public String documentNumber() {
        return super.getParameterAsString("document_number");
    }

    public String documentType() {
        return super.getParameterAsString("document_type");
    }

    public String name() {
        return super.getParameterAsString("name");
    }

    public String email() {
        return super.getParameterAsString("email");
    }

    public List<String> phoneNumbers() {
        return super.getParameterAsStringList("phone_numbers");
    }

    public String bornAt() {
        return super.getParameterAsString("born_at");
    }

    public String birthday() {
        return super.getParameterAsString("birthday");
    }

    public String gender() {
        return super.getParameterAsString("gender");
    }

    public String dateCreated() {
        return super.getParameterAsString("date_created");
    }

    public List<Document> documents() {
        return super.getParameterAsObjectList("documents", Document.class);
    }

    public List<Address> addresses() {
        return super.getParameterAsObjectList("addresses", Address.class);
    }

    public List<Phone> phones() {
        return super.getParameterAsObjectList("phones", Phone.class);
    }
}

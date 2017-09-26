package me.pagar.requestobject;

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
        return "customer";
    }

    public Customer id(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public Customer externalId(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String externalId() {
        return super.getParameterAsString("external_id");
    }

    public Customer name(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String name() {
        return super.getParameterAsString("name");
    }

    public Customer type(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String type() {
        return super.getParameterAsString("type");
    }

    public Customer country(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String country() {
        return super.getParameterAsString("country");
    }

    public Customer email(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String email() {
        return super.getParameterAsString("email");
    }

    public Customer documents(String parameterName, List<Document> parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public List<Document> documents() {
        return super.getParameterAsObjectList("documents", Document.class);
    }

    public Customer phoneNumbers(String parameterName, List<String> parameterValue) {
        super.setParameterCollection(parameterName, parameterValue);
        return this;
    }

    public List<String> phoneNumbers() {
        return super.getParameterAsStringList("phone_numbers");
    }

    public Customer birthday(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String birthday() {
        return super.getParameterAsString("birthday");
    }
}

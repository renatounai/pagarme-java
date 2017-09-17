package me.pagar.route.requestobject;

import me.pagar.route.FieldsOnHash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer extends FieldsOnHash {

    public Customer() {
        super(new HashMap<String, Object>());
    }

    public Customer(Map<String, Object> parameters) {
        super(parameters);
    }

    public Customer(String jsonString) {
        super(jsonString);
    }

    public String getExternalId() {
        return super.getParameterAsString("externalId");
    }

    public Customer setExternalId(String externalId) {
        super.setParameter("external_id", externalId);
        return this;
    }

    public String getName() {
        return super.getParameterAsString("name");
    }

    public Customer setName(String name) {
        super.setParameter("name", name);
        return this;
    }

    public String getType() {
        return super.getParameterAsString("type");
    }

    public Customer setType(String type) {
        super.setParameter("type", type);
        return this;
    }

    public String getCountry() {
        return super.getParameterAsString("country");
    }

    public Customer setCountry(String country) {
        super.setParameter("country", country);
        return this;
    }

    public String getEmail() {
        return super.getParameterAsString("email");
    }

    public Customer setEmail(String email) {
        super.setParameter("email", email);
        return this;
    }

    public List<Document> getDocuments() {
        return super.<Document>getParameterAsList("documents");
    }

    public Customer setDocuments(List<Document> documents) {
        super.setParameter("documents", documents);
        return this;
    }

    public List<String> getPhoneNumbers() {
        return super.getParameterAsStringList("phone_numbers");
    }

    public Customer setPhoneNumbers(List<String> phoneNumbers) {
        super.setParameterCollection("phone_numbers", phoneNumbers);
        return this;
    }

    public String getBirthday() {
        return super.getParameterAsString("birthday");
    }

    public Customer setBirthday(String birthday) {
        super.setParameter("birthday", birthday);
        return this;
    }

}

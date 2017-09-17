package me.pagar.route.requestobject;

import me.pagar.route.FieldsOnHash;

import java.util.HashMap;
import java.util.Map;

public class Shipping extends FieldsOnHash{

    public Shipping() {
        super(new HashMap<String, Object>());
    }

    public Shipping(Map<String, Object> parameters) {
        super(parameters);
    }

    public Shipping(String jsonString) {
        super(jsonString);
    }

    public String getName() {
        return super.getParameterAsString("name");
    }

    public Shipping setName(String name) {
        super.setParameter("name", name);
        return this;
    }

    public Integer getFee() {
        return super.getParameterAsInteger("fee");
    }

    public Shipping setFee(Integer fee) {
        super.setParameter("fee", fee);
        return this;
    }

    public String getDeliveryDate() {
        return super.getParameterAsString("deliveryDate");
    }

    public Shipping setDeliveryDate(String deliveryDate) {
        super.setParameter("deliveryDate", deliveryDate);
        return this;
    }

    public Boolean getExpedited() {
        return super.getParameterAsBoolean("expedited");
    }

    public Shipping setExpedited(Boolean expedited) {
        super.setParameter("expedited", expedited);
        return this;
    }

    public Address getAddress() {
        try {
            return super.getParameterCasted("address", new Address());
        } catch (Exception e) {
            return null;
        }
    }

    public Shipping setAddress(Address address) {
        super.setParameter("address", address);
        return this;
    }

}

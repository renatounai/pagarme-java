package me.pagar.route.requestobject;

import me.pagar.route.FieldsOnHash;

import java.util.HashMap;
import java.util.Map;

public class Item extends FieldsOnHash{

    public Item() {
        super(new HashMap<String, Object>());
    }

    public Item(Map<String, Object> parameters) {
        super(parameters);
    }

    public Item(String jsonString) {
        super(jsonString);
    }

    public String getId() {
        return super.getParameterAsString("id");
    }

    public Item setId(String id) {
        super.setParameter("id", id);
        return this;
    }

    public String getTitle() {
        return super.getParameterAsString("title");
    }

    public Item setTitle(String title) {
        super.setParameter("title", title);
        return this;
    }

    public Integer getUnitPrice() {
        return super.getParameterAsInteger("unit_price");
    }

    public Item setUnitPrice(Integer unitPrice) {
        super.setParameter("unit_price", unitPrice);
        return this;
    }

    public Integer getQuantity() {
        return super.getParameterAsInteger("quantity");
    }

    public Item setQuantity(Integer quantity) {
        super.setParameter("quantity", quantity);
        return this;
    }

    public Boolean getTangible() {
        return super.getParameterAsBoolean("tangible");
    }

    public Item setTangible(Boolean tangible) {
        super.setParameter("tangible", tangible);
        return this;
    }

}

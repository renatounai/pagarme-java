package me.pagar.requestobject;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class Item extends FieldsOnHash implements ResourceObject {
    public Item() {
        super(new HashMap<String, Object>());
    }

    public Item(Map<String, Object> parameters) {
        super(parameters);
    }

    public Item(String jsonString) {
        super(jsonString);
    }

    public String object() {
        return "item";
    }

    public Item id(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public Item title(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String title() {
        return super.getParameterAsString("title");
    }

    public Item unitPrice(String parameterName, Integer parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Integer unitPrice() {
        return super.getParameterAsInteger("unit_price");
    }

    public Item quantity(String parameterName, Integer parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Integer quantity() {
        return super.getParameterAsInteger("quantity");
    }

    public Item category(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String category() {
        return super.getParameterAsString("category");
    }

    public Item tangible(String parameterName, Boolean parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public Boolean tangible() {
        return super.getParameterAsBoolean("tangible");
    }

    public Item venue(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String venue() {
        return super.getParameterAsString("venue");
    }

    public Item date(String parameterName, String parameterValue) {
        super.setParameter(parameterName, parameterValue);
        return this;
    }

    public String date() {
        return super.getParameterAsString("date");
    }
}

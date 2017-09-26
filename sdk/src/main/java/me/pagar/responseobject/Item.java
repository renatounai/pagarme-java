package me.pagar.responseobject;

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
        return super.getParameterAsString("object");
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public String title() {
        return super.getParameterAsString("title");
    }

    public Integer unitPrice() {
        return super.getParameterAsInteger("unit_price");
    }

    public Integer quantity() {
        return super.getParameterAsInteger("quantity");
    }

    public String category() {
        return super.getParameterAsString("category");
    }

    public Boolean tangible() {
        return super.getParameterAsBoolean("tangible");
    }

    public String venue() {
        return super.getParameterAsString("venue");
    }

    public String date() {
        return super.getParameterAsString("date");
    }
}

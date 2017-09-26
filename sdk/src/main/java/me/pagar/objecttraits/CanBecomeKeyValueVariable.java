package me.pagar.objecttraits;


import java.util.Map;

public interface CanBecomeKeyValueVariable extends CanBecomeQueryString {

    String toJson();
    Map<String, Object> toMap();
}

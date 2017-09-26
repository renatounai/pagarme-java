package me.pagar.exception;

public class Messages {

    public static final String INCOMPATIBLE_CLASS_FIELDS_ON_HASH = "CanLoadFieldsFromSources' subclasses should be instantiable with no parameters";
    public static final String INCOMPATIBLE_CLASS_NOT_CONVERTIBLE = "Value cannot be interpreted as the expected type";
    public static final String INCOMPATIBLE_CLASS(String variableMessage) {
        return String.format("Class not instantiable as expected. %s", variableMessage);
    }
    public static final String NOFIELDWITHNAME_FIELD_NOT_FOUND_FORMAT(String fieldName) {
        return String.format("Parameter %s not found", fieldName);
    }

}

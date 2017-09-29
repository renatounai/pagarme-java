package me.pagar.objecttraits;

import java.util.Map;

public interface CanLoadFieldsFromSources {

    void loadParametersFrom(Map<String, Object> parameters);
    void loadParametersFrom(String jsonString);
    void setParameter(String parameterName, String parameterValue);
}

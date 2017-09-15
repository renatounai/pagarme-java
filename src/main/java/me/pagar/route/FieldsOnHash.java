package me.pagar.route;

import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.operations.Bool;
import me.pagar.converter.JSonConverter;

import java.util.HashMap;
import java.util.Map;

public abstract class FieldsOnHash implements CanLoadFieldsFromSources, CanBecomeKeyValueVariable {

    //String => (number | string | Map)
    private HashMap<String, Object> fields;

    public FieldsOnHash(String jsonString){
        loadParametersFrom(jsonString);
    }

    public FieldsOnHash(Map<String, Object> parameters){
        loadParametersFrom(parameters);
    }

    protected HashMap<String, Object> allFields(){
        return this.fields;
    }

    public Integer getParameterAsInteger(String parameterName){
        Object parameter = fields.get(parameterName);
        Integer parameterAsInteger = Integer.valueOf(parameter.toString());
        return parameterAsInteger;
    }

    public String getParameterAsString(String parameterName){
        Object parameter = fields.get(parameterName);
        String parameterAsString = parameter.toString();
        return parameterAsString;
    }

    public Boolean getParameterAsBoolean(String parameterName){
        Object parameter = fields.get(parameterName);
        Boolean parameterAsBoolean = Boolean.valueOf(parameter.toString());
        return parameterAsBoolean;
    }

    public <T extends FieldsOnHash> T getParameterCasted(String parameterName, Class<T> parameterClass) throws IllegalAccessException, InstantiationException {
        T classInstance = parameterClass.newInstance();
        Object parameterValue = fields.get(parameterName);
        classInstance.loadParametersFrom((Map<String, Object>)parameterValue);

        return classInstance;
    }

    public HashMap<String, Object> getParameterAsMap(String parameterName) {
        Object parameterValue = this.getParameter(parameterName);
        return (HashMap<String, Object>)parameterValue;
    }

    public <T extends Enum> T getParameterAsEnum(String parameterName, Class<T> parameterClass) throws IllegalAccessException, InstantiationException {
        String parameterValue = getParameterAsString(parameterName);
        T classInstance = Enum.valueOf(parameterClass, parameterValue);
        return classInstance;
    }

    public void setParameter(String parameterName, Object parameterValue){
        this.fields.put(parameterName, parameterValue);
    }

    @Override
    public void loadParametersFrom(Map<String, Object> parameters) {
        fields.putAll(parameters);
    }

    //TODO - parametrize Gson
    @Override
    public void loadParametersFrom(String jsonString) {
        Map<String, Object> hashedJson = new Gson().fromJson(jsonString, HashMap.class);
        loadParametersFrom(hashedJson);
    }

    //TODO - parametrize Gson
    @Override
    public String toJson(){
        String jsonString = new Gson().toJson(this.fields);
        return jsonString;
    }

    public Object getParameter(String parameterName) {
        return this.fields.get(parameterName);
    }
}

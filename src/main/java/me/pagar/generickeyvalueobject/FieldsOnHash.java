package me.pagar.generickeyvalueobject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.pagar.exception.IncompatibleClass;
import me.pagar.exception.NoFieldWithName;
import me.pagar.objecttraits.CanBecomeKeyValueVariable;
import me.pagar.objecttraits.CanLoadFieldsFromSources;

import java.util.*;
import java.util.stream.Collectors;

public abstract class FieldsOnHash implements CanLoadFieldsFromSources, CanBecomeKeyValueVariable {

    //String => (number | string | Map)
    private Map<String, Object> fields = new HashMap<>();

    public FieldsOnHash(String jsonString){
        loadParametersFrom(jsonString);
    }

    public FieldsOnHash(Map<String, Object> parameters){
        loadParametersFrom(parameters);
    }

    public Map<String, Object> toMap(){
        return this.fields;
    }

    public Integer getParameterAsInteger(String parameterName) throws NoFieldWithName, IncompatibleClass {
        Object parameter = getParameterReferenceOrDefault(parameterName);
        if(parameter == null) {
            return null;
        }

        try {
            Integer parameterAsInteger = Integer.valueOf(String.valueOf(parameter));
            return parameterAsInteger;
        } catch (NumberFormatException e) {
            throw new IncompatibleClass();
        }
    }

    public String getParameterAsString(String parameterName) throws NoFieldWithName {
        Object parameter = getParameterReferenceOrDefault(parameterName);
        if(parameter == null){
            return "null";
        } else {
            String parameterAsString = String.valueOf(parameter);
            return parameterAsString;
        }
    }

    public Boolean getParameterAsBoolean(String parameterName) throws NoFieldWithName, IncompatibleClass {
        Object parameter = getParameterReferenceOrDefault(parameterName);
        if(parameter == null) {
            return null;
        }

        String parameterText = String.valueOf(parameter).toLowerCase();
        Boolean parameterIsNotLikeBoolean = !parameterText.equals("true") && !parameter.equals("false");
        if(parameterIsNotLikeBoolean) {
            throw new IncompatibleClass();
        }
        Boolean parameterAsBoolean = Boolean.valueOf(parameterText);
        return parameterAsBoolean;
    }

    public List<String> getParameterAsStringList(String parameterName) throws NoFieldWithName, IncompatibleClass {
        Object parameter = getParameterReferenceOrDefault(parameterName);
        try {
            return (List<String>) parameter;
        } catch (ClassCastException e) {
            throw new IncompatibleClass();
        }
    }

    public <T extends CanLoadFieldsFromSources> List<T> getParameterAsObjectList(String parameterName, Class<T> objectClass) throws NoFieldWithName, IncompatibleClass {
        Object parameterValue =  getParameterReferenceOrDefault(parameterName);

        try {
            List<Map<String, Object>> parameterValueCasted = (List<Map<String, Object>>) parameterValue;
            if(parameterValue == null) {
                return null;
            }

            List<T> instanciatedObjects = new ArrayList<>();
            for(Map<String, Object> map : parameterValueCasted) {
                T objectInstance = objectClass.newInstance();
                objectInstance.loadParametersFrom(map);
                instanciatedObjects.add(objectInstance);
            }
            return instanciatedObjects;
        } catch (Exception e) {
            throw new IncompatibleClass();
        }

    }

    public <T extends CanLoadFieldsFromSources> T getParameterCasted(String parameterName, T classInstance) throws NoFieldWithName, IncompatibleClass {
        Map<String, Object> classInstanceParameters = getParameterAsMap(parameterName);

        if(classInstanceParameters == null) {
            return null;
        }
        classInstance.loadParametersFrom(classInstanceParameters);
        return classInstance;
    }

    public Map<String, Object> getParameterAsMap(String parameterName) throws NoFieldWithName, IncompatibleClass {
        Object parameterValue = this.getParameterReferenceOrDefault(parameterName);
        try {
            return (Map<String, Object>)parameterValue;
        } catch (ClassCastException e) {
            throw new IncompatibleClass();
        }
    }

    public void setParameter(String parameterName, String parameterValue){
        this.fields.put(parameterName, parameterValue);
    }

    public void setParameter(String parameterName, Integer parameterValue){
        this.fields.put(parameterName, parameterValue);
    }

    public void setParameter(String parameterName, Map<String, Object> parameterValue){
        this.fields.put(parameterName, parameterValue);
    }

    public void setParameter(String parameterName, Boolean parameterValue){
        this.fields.put(parameterName, parameterValue);
    }

    public void setParameter(String parameterName, CanBecomeKeyValueVariable child){
        this.fields.put(parameterName, child.toMap());
    }

    public <T extends CanBecomeKeyValueVariable> void setParameter(String parameterName, Collection<T> list) {
        List<Map<String, Object>> mappedObjects = list.stream()
                .map((item) -> item.toMap())
                .collect(Collectors.toList());
        this.fields.put(parameterName, mappedObjects);
    }

    public void setParameterCollection(String parameterName, Collection<String> collection) {
        this.fields.put(parameterName, collection);
    }

    @Override
    public void loadParametersFrom(Map<String, Object> parameters) {
        this.fields = parameters;
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
        Gson gson = new GsonBuilder().serializeNulls().create();
        String jsonString = gson.toJson(this.fields);
        return jsonString;
    }

    public String toQueryString(){
        return CreateQueryString.toQueryString(this.fields);
    }

    protected Object getParameterReferenceOrDefault(String parameterName) throws NoFieldWithName {
        if(this.fields.containsKey(parameterName)) {
            Object parameterValue = this.fields.get(parameterName);
            return parameterValue;
        } else {
            throw new NoFieldWithName();
        }
    }

    public boolean equals(FieldsOnHash other) {
        return this.fields.equals(other.fields);
    }
}

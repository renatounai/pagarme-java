package me.pagar.generickeyvalueobject;

import me.pagar.exception.IncompatibleClass;
import me.pagar.exception.Messages;
import me.pagar.exception.NoFieldWithName;
import me.pagar.objecttraits.CanBecomeKeyValueVariable;
import me.pagar.objecttraits.CanLoadFieldsFromSources;
import me.pagar.resource.JsonConverter;
import me.pagar.resource.GsonConverter;

import java.util.*;
import java.util.stream.Collectors;

public abstract class FieldsOnHash implements CanLoadFieldsFromSources, CanBecomeKeyValueVariable {

    //String => (number | string | Map)
    private Map<String, Object> fields;
    private JsonConverter converter;

    public FieldsOnHash(String json, JsonConverter converter) {
        this.converter = converter;
        loadParametersFrom(json);
    }

    public FieldsOnHash(Map<String, Object> parameters, JsonConverter converter) {
        this.converter = converter;
        loadParametersFrom(parameters);
    }

    public FieldsOnHash(String jsonString){
        this.converter = new GsonConverter();
        loadParametersFrom(jsonString);
    }

    public FieldsOnHash(Map<String, Object> parameters){
        this.converter = new GsonConverter();
        loadParametersFrom(parameters);
    }

    public FieldsOnHash(){
        this.converter = new GsonConverter();
        loadParametersFrom(new HashMap<>());
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
            throw new IncompatibleClass(Messages.INCOMPATIBLE_CLASS_NOT_CONVERTIBLE, e);
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
            throw new IncompatibleClass(Messages.INCOMPATIBLE_CLASS_NOT_CONVERTIBLE);
        }
        Boolean parameterAsBoolean = Boolean.valueOf(parameterText);
        return parameterAsBoolean;
    }

    public List<String> getParameterAsStringList(String parameterName) throws NoFieldWithName, IncompatibleClass {
        Object parameter = getParameterReferenceOrDefault(parameterName);
        try {
            return (List<String>) parameter;
        } catch (ClassCastException e) {
            throw new IncompatibleClass(Messages.INCOMPATIBLE_CLASS_NOT_CONVERTIBLE, e);
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
        } catch (ClassCastException e) {
            throw new IncompatibleClass(Messages.INCOMPATIBLE_CLASS_NOT_CONVERTIBLE, e);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IncompatibleClass(Messages.INCOMPATIBLE_CLASS_FIELDS_ON_HASH, e);
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
            throw new IncompatibleClass(Messages.INCOMPATIBLE_CLASS_NOT_CONVERTIBLE, e);
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
        Map<String, Object> hashedJson = converter.stringToMap(jsonString);
        loadParametersFrom(hashedJson);
    }

    //TODO - parametrize Gson
    @Override
    public String toJson(){
        String jsonString = this.converter.mapToString(this.fields);
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
            throw new NoFieldWithName(Messages.NOFIELDWITHNAME_FIELD_NOT_FOUND_FORMAT(parameterName));
        }
    }

    public boolean equals(FieldsOnHash other) {
        return this.fields.equals(other.fields);
    }
}

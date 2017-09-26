package me.pagar.generickeyvalueobject;

import me.pagar.objecttraits.CanBecomeQueryString;

import java.util.*;

/**
 * Created by henriquekano on 9/22/17.
 */
public class QueriableParameters implements CanBecomeQueryString {

    private List<Map.Entry<String, Object>> fields = new ArrayList<>();

    public void count(Integer count) {
        equals("count", count);
    }

    public void equals(String parameterName, Boolean parameterValue) {
        addAndStringifyNull(parameterName, parameterValue);
    }

    public void notEquals(String parameterName, Boolean parameterValue) {
        addAndStringifyNull(parameterName, "!=" + parameterValue);
    }

    public void equals(String parameterName, Integer parameterValue) {
        addAndStringifyNull(parameterName, parameterValue);
    }

    public void notEquals(String parameterName, Integer parameterValue) {
        addAndStringifyNull(parameterName, "!=" + parameterValue );
    }

    public void lessThan(String parameterName, Integer parameterValue) {
        addAndStringifyNull(parameterName, "<" + parameterValue);
    }

    public void lessThanOrEquals(String parameterName, Integer parameterValue) {
        addAndStringifyNull(parameterName, "<=" + parameterValue);
    }

    public void moreThan(String parameterName, Integer parameterValue) {
        addAndStringifyNull(parameterName, ">" + parameterValue);
    }

    public void moreThanOrEquals(String parameterName, Integer parameterValue) {
        addAndStringifyNull(parameterName, ">=" + parameterValue);
    }

    public void equals(String parameterName, String parameterValue) {
        addAndStringifyNull(parameterName, parameterValue);
    }

    public void notEquals(String parameterName, String parameterValue) {
        addAndStringifyNull(parameterName, "!=" + parameterValue);
    }

    public void lessThan(String parameterName, String parameterValue) {
        addAndStringifyNull(parameterName, "<" + parameterValue);
    }

    public void lessThanOrEquals(String parameterName, String parameterValue) {
        addAndStringifyNull(parameterName, "<=" + parameterValue);
    }

    public void moreThan(String parameterName, String parameterValue) {
        addAndStringifyNull(parameterName, ">" + parameterValue);
    }

    public void moreThanOrEquals(String parameterName, String parameterValue) {
        addAndStringifyNull(parameterName, "=>" + parameterValue);
    }

    private void addAndStringifyNull(String parameterName, Object parameterValue) {
        Object nonNullValue = parameterValue == null ? "null" : parameterValue;
        this.fields.add(new AbstractMap.SimpleEntry<String, Object>(parameterName, nonNullValue));
    }

    public void set(String parameterName, Object parameterValue) {
        this.fields.add(new AbstractMap.SimpleEntry<String, Object>(parameterName, parameterValue));
    }

    public List<AbstractMap.Entry<String, Object>> parameter(String parameterName) {
        List<AbstractMap.Entry<String, Object>> returnList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : this.fields) {
            if (entry.getKey().equals(parameterName)) {
                returnList.add(entry);
            }
        }
        return returnList;
    }

    @Override
    public String toQueryString() {
        return CreateQueryString.toQueryString(this.fields);
    }
}

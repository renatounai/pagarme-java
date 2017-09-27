package me.pagar.generickeyvalueobject;

import com.google.common.collect.Maps;
import me.pagar.exception.IncompatibleClass;
import me.pagar.exception.Messages;
import me.pagar.objecttraits.CanBecomeQueryString;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by henriquekano on 9/22/17.
 */
public class QueriableParameters implements CanBecomeQueryString {

    private List<Map.Entry<String, Object>> fields = new ArrayList<Map.Entry<String, Object>>();

    public void count(Integer count) {
        equals("count", count);
    }

    public void page(Integer page) {
        equals("page", page);
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
        addAndStringifyNull(parameterName, ">=" + parameterValue);
    }

    private void addAndStringifyNull(String parameterName, Object parameterValue) {
        Object nonNullValue = parameterValue == null ? "null" : parameterValue;
        set(parameterName, nonNullValue);
    }

    public void set(String parameterName, Object parameterValue) {
        this.fields.add(Maps.immutableEntry(parameterName, parameterValue));
    }

    public List<Map.Entry<String, Object>> parameter(String parameterName) {
        List<Map.Entry<String, Object>> returnList = new ArrayList<Map.Entry<String, Object>>();
        for (Map.Entry<String, Object> entry : this.fields) {
            if (entry.getKey().equals(parameterName)) {
                Maps.immutableEntry(parameterName, entry.getValue());
                returnList.add(entry);
            }
        }
        return returnList;
    }

    public String toQueryString() {
        return CreateQueryString.toQueryString(this.fields);
    }
}

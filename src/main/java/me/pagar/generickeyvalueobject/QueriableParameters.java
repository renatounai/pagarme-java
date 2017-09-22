package me.pagar.generickeyvalueobject;

import me.pagar.objecttraits.CanBecomeQueryString;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by henriquekano on 9/22/17.
 */
public class QueriableParameters implements CanBecomeQueryString {

    private List<Map.Entry<String, Object>> fields = new ArrayList<>();

    public void setParameter(String parameterName, String parameterValue) {
        this.setParameterObject(parameterName, (Object)parameterValue);
    }

    public void setParameter(String parameterName, Integer parameterValue) {
        this.setParameterObject(parameterName, (Object)parameterValue);
    }

    public void setParameter(String parameterName, Boolean parameterValue) {
        this.setParameterObject(parameterName, (Object)parameterValue);
    }

    public void setStringList(String parameterName, List<String> parameterValue) {
        this.setParameterObject(parameterName, (Object)parameterValue);
    }

    public void setIntegerList(String parameterName, List<Integer> parameterValue) {
        this.setParameterObject(parameterName, (Object)parameterValue);
    }

    public void setMapList(String parameterName, List<Map<String, Object>> parameterValue) {
        this.setParameterObject(parameterName, (Object)parameterValue);
    }

    public void setParameter(String parameterName, Map<String, Object> parameterValue) {
        this.setParameterObject(parameterName, (Object)parameterValue);
    }

    private void setParameterObject(String parameterName, Object parameterValue) {
        Map.Entry<String, Object> entry = new AbstractMap.SimpleEntry(parameterName, parameterValue);
        this.fields.add(entry);
    }

    @Override
    public String toQueryString() {
        return CreateQueryString.toQueryString(this.fields);
    }
}

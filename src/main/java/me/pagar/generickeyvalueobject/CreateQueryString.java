package me.pagar.generickeyvalueobject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by henriquekano on 9/22/17.
 */
class CreateQueryString {

    public static <T extends Map.Entry<String, Object>> String toQueryString(Collection<T> fields) {
        StringBuilder builder = new StringBuilder();
        toQueryParamsRecursive(new ArrayList<String>(), fields, builder);
        return builder.toString().replaceAll("&$", "");
    }

    public static String toQueryString(Map<String, Object> fields) {
        StringBuilder builder = new StringBuilder();
        toQueryParamsRecursive(new ArrayList<String>(), fields.entrySet(), builder);
        return builder.toString().replaceAll("&$", "");
    }

    //TODO - make it readable...
    @SuppressWarnings("unchecked")
    private static <T extends Map.Entry<String, Object>> void toQueryParamsRecursive(List<String> context, Collection<T> fields, StringBuilder result){
        for (Map.Entry<String, Object> keyValuePair : fields) {
            String key = keyValuePair.getKey();
            Object value = keyValuePair.getValue();

            if(value instanceof Map) {
                List<String> newContext = new ArrayList<String>();
                newContext.addAll(context);
                newContext.add(key);
                toQueryParamsRecursive(newContext, ((Map) value).entrySet(), result);
            } else if(value instanceof String || value instanceof Integer || value instanceof Boolean) {
                if(context.size() > 0){
                    String prefix = joinContext(context);
                    result.append(prefix + "[" + key + "]=" + value + "&");
                }else{
                    result.append(key + "=" + value + "&");
                }
            } else if (value instanceof List) {
                List castedValue = (List)value;
                for (int i = 0; i < castedValue.size(); i++) {
                    String castedValueString = objectToQueryStringRepresentation(castedValue.get(i));
                    if(context.size() > 0){
                        String prefix = joinContext(context);
                        result.append(prefix + "[" + key + "][" + i + "]=" + castedValueString + "&");
                    }else{
                        result.append(key + "[" + i + "]=" + castedValueString + "&");
                    }
                }
            }
        }
    }

    private static String joinContext(List<String> context) {
        String prefix = context.get(0);
        for(int j = 1; j < context.size(); j++){
            prefix += "[" + context.get(j) + "]";
        }
        return prefix;
    }

    private static String objectToQueryStringRepresentation(Object object) {
        if (object == null) {
            return "null";
        } else if (object instanceof String || object instanceof Integer || object instanceof Boolean) {
            return object.toString();
        } else if (object instanceof List) {
            return "[]";
        } else {
            return "";
        }
    }
}

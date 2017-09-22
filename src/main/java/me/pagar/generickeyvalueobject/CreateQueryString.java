package me.pagar.generickeyvalueobject;

import java.util.*;

/**
 * Created by henriquekano on 9/22/17.
 */
class CreateQueryString {

    private CreateQueryString(){}

    static <T extends Map.Entry<String, Object>> String toQueryString(Collection<T> fields) {
        StringBuilder builder = new StringBuilder();
        toQueryParamsRecursive(new ArrayList<>(), fields, builder);
        return builder.toString().replaceAll("&$", "");
    }

    static String toQueryString(Map<String, Object> fields) {
        StringBuilder builder = new StringBuilder();
        toQueryParamsRecursive(new ArrayList<>(), fields.entrySet(), builder);
        return builder.toString().replaceAll("&$", "");
    }

    //TODO - make it readable...
    private static <T extends Map.Entry<String, Object>> void toQueryParamsRecursive(List<String> context, Collection<T> fields, StringBuilder result){
        for (Map.Entry<String, Object> keyValuePair : fields) {
            String key = keyValuePair.getKey();
            Object value = keyValuePair.getValue();

            if(value instanceof Map) {
                List<String> newContext = new ArrayList<>();
                Map<String, Object> castedValue = (Map<String, Object>) value;
                Set<Map.Entry<String, Object>> entrySet = castedValue.entrySet();
                newContext.addAll(context);
                newContext.add(key);
                toQueryParamsRecursive(newContext, entrySet, result);
            } else if(value instanceof String || value instanceof Integer || value instanceof Boolean) {
                addEntryBasedOnContext(context, key, "", value, result);
            } else if (value instanceof List) {
                List castedValue = (List)value;
                for (int i = 0; i < castedValue.size(); i++) {
                    addEntryBasedOnContext(context, key, "[" + i + "]", castedValue.get(i), result);
                }
            }
        }
    }

    private static String joinContext(List<String> context) {
        StringBuilder prefix = new StringBuilder(context.get(0));
        for(int j = 1; j < context.size(); j++){
            prefix
                .append("[")
                .append(context.get(j))
                .append("]");
        }
        return prefix.toString();
    }

    private static void addEntryBasedOnContext(List<String> context, String key, String keyComplement, Object value, StringBuilder result) {
        String castedValueString = objectToQueryStringRepresentation(value);
        if(context != null && !context.isEmpty()){
            String prefix = joinContext(context);
            result
                .append(prefix)
                .append("[")
                .append(key)
                .append("]")
                .append(keyComplement)
                .append("=")
                .append(castedValueString)
                .append("&");
        }else{
            result
                .append(key)
                .append(keyComplement)
                .append("=")
                .append(castedValueString)
                .append("&");
        }
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

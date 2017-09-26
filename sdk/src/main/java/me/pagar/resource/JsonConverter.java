package me.pagar.resource;

import java.util.List;
import java.util.Map;

public interface JsonConverter {

    <T extends Map<String, Object>> List<T> stringToMapList(String json);
    <T extends Map<String, Object>> T stringToMap(String json);
    String mapToString(Map<String, Object>json);

}

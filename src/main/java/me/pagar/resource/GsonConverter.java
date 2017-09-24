package me.pagar.resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class GsonConverter implements JsonConverter {

    public Gson gson;

    public GsonConverter() {
        this.gson = new GsonBuilder()
            .serializeNulls()
            .create();
    }

    @Override
    public <T extends Map<String, Object>> List<T> stringToMapList(String json) {
        Type listType = new TypeToken<List<T>>(){}.getType();
        List<T> mapList = this.gson.fromJson(json, listType);
        return mapList;
    }

    @Override
    public Map<String, Object> stringToMap(String json) {
        Type mapType = new TypeToken<Map<String, Object>>(){}.getType();
        Map<String, Object> mapList = this.gson.fromJson(json, mapType);
        return mapList;
    }

    @Override
    public String mapToString(Map<String, Object> map) {
        Type mapType = new TypeToken<Map<String, Object>>(){}.getType();
        String json = this.gson.toJson(map, mapType);
        return json;
    }
}

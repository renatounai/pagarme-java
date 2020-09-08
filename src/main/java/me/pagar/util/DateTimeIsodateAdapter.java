package me.pagar.util;

import com.google.common.base.Strings;
import com.google.gson.*;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.lang.reflect.Type;

public class DateTimeIsodateAdapter implements DateTimeAdapter {

    private final DateTimeFormatter formatter;

    public DateTimeIsodateAdapter() {
        this.formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    }

    public DateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final String dateTime = json.getAsString();
        try {
            return Strings.isNullOrEmpty(dateTime) ? null : formatter.parseDateTime(dateTime);
        } catch (Exception e) {
            return null;
        }
    }

    public JsonElement serialize(DateTime src, Type typeOfSrc, JsonSerializationContext context) {
        return src == null ? null : new JsonPrimitive(formatter.print(src));
    }

}

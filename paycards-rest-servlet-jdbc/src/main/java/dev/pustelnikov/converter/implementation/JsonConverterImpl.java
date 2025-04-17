package dev.pustelnikov.converter.implementation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.pustelnikov.converter.JsonConverter;
import dev.pustelnikov.converter.utility.LocalDateTypeAdapter;
import java.lang.reflect.Type;
import java.time.LocalDate;

public final class JsonConverterImpl implements JsonConverter {
    private final Gson gson;

    public JsonConverterImpl() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .create();
    }

    @Override
    public String convertToJson(Object object) {
        return gson.toJson(object);
    }

    @Override
    public Object convertToObject(String string, Type type) {
        return gson.fromJson(string, type);
    }
}

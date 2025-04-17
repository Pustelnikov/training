package dev.pustelnikov.converter;

import java.lang.reflect.Type;

public interface JsonConverter {
    String convertToJson(Object object);
    Object convertToObject(String string, Type type);
}

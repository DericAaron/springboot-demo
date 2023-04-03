package com.challenge.demo.utility;

import java.lang.reflect.Field;
import java.util.HashMap;

public class Utility {
    public static HashMap<String, Object> objectToHashMap(Object object) throws IllegalAccessException {
        HashMap<String, Object> map = new HashMap<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object fieldValue = field.get(object);
            map.put(fieldName, fieldValue);
        }
        return map;
    }
}

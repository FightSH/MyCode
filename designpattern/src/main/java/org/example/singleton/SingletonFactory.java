package org.example.singleton;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class SingletonFactory {


    private static final Map<String, Object> OBJECT_MAP = new HashMap<>();

    private SingletonFactory() {
    }


    public static <T> T getInstance(Class<T> tClass) {

        String key = tClass.toString();
        Object instance = OBJECT_MAP.get(key);

        if (instance == null) {
            synchronized (SingletonFactory.class) {
                instance = OBJECT_MAP.get(key);
                if (instance == null) {
                    try {
                        instance = tClass.getDeclaredConstructor().newInstance();
                        OBJECT_MAP.put(key, instance);
                    } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return tClass.cast(instance);

    }



}

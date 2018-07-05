package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        V v = cache.get(key);

        if (v == null) {
            Constructor<V> constructor = clazz.getConstructor(key.getClass());
            v = constructor.newInstance(key);
            cache.put(key, v);
        }

        return v;
    }

    public boolean put(V obj) {

        try {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            K key = (K) method.invoke(obj);
            cache.put(key, obj);

            return true;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ignore) {
        }

        return false;
    }

    public int size() {
        return cache.size();
    }
}

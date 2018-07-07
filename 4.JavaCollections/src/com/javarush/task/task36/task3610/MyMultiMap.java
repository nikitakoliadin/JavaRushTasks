package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {

    static final long serialVersionUID = 123456789L;

    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;

        map = new HashMap<>();
    }

    @Override
    public int size() {
        return values().size();
    }

    @Override
    public V put(K key, V value) {

        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<V>(){{add(value);}});
            return null;
        } else {
            List<V> listOfValues = map.get(key);

            V result = listOfValues.get(listOfValues.size() - 1);

            if (listOfValues.size() >= repeatCount) {
                listOfValues.remove(0);
            }

            listOfValues.add(value);
            map.put(key, listOfValues);

            return result;
        }
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        List<V> listOfValues = map.get(key);

        if (listOfValues == null) {
            return null;
        }

        V value = listOfValues.get(0);
        listOfValues.remove(value);

        if (listOfValues.size() == 0) {
            map.remove(key);
        }

        return value;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        List<V> values = new ArrayList<>();

        map.values().forEach(values::addAll);

        return values;
    }

    @Override
    public boolean containsKey(Object key) {
        return keySet().contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}
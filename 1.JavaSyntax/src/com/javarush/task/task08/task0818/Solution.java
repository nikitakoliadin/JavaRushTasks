package com.javarush.task.task08.task0818;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 500);
        map.put("2", 600);
        map.put("3", 400);
        map.put("4", 500);
        map.put("5", 700);
        map.put("6", 850);
        map.put("7", 200);
        map.put("8", 100);
        map.put("9", 501);
        map.put("10", 100);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        ArrayList<String> delete = new ArrayList<>();
        for (Map.Entry<String,Integer>pair : map.entrySet()){
            if (pair.getValue() < 500)
                delete.add(pair.getKey());
        }
        for(String key: delete)
            map.remove(key);
    }

    public static void main(String[] args) {
    }
}
package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("q","w");
        map.put("e","w");
        map.put("t","y");
        map.put("u","i");
        map.put("o","p");
        map.put("[","]");
        map.put("a","s");
        map.put("d","f");
        map.put("g","h");
        map.put("h","w");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int count = 0;
        for(Map.Entry<String, String>pair : map.entrySet()) {
            if (pair.getValue().equals(name)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int count = 0;
        for (Map.Entry<String,String>pair : map.entrySet()) {
            if(pair.getKey().equals(lastName)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getCountTheSameFirstName(createMap(),"w"));
    }
}

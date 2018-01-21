package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        HashMap<String,String> map = new HashMap<>();
        map.put("1","2");
        map.put("3","4");
        map.put("7","13");
        map.put("6","7");
        map.put("9","8");
        map.put("10","2");
        map.put("1","12");
        map.put("q","13");
        map.put("3","t");
        map.put("e","4");
        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}

package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> data = new LinkedHashMap<>();
        data.put("name", "Ivanov");
        data.put("country", "Ukraine");
        data.put("city", "Kiev");
        data.put("age", "10");
        System.out.println(getQuery(data));

        Map<String, String> emptyMap = new LinkedHashMap<>();
        System.out.println(getQuery(emptyMap));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");

        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() != null && pair.getKey() != null) {
                if (stringBuilder.toString().equals("")){
                    stringBuilder.append(pair.getKey())
                            .append(" = ")
                            .append("\'")
                            .append(pair.getValue())
                            .append("\'");
                } else {
                    stringBuilder.append(" and ")
                            .append(pair.getKey())
                            .append(" = ")
                            .append("\'")
                            .append(pair.getValue())
                            .append("\'");
                }
            }
        }
        return stringBuilder.toString();
    }
}

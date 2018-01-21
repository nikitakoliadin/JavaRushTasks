package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        while (true) {
            int id;
            try {
                id = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                break;
            }

            String name = reader.readLine();

            if (name.isEmpty()) {
                break;
            }

            map.put(name, id);
        }

        for(String key : map.keySet()) {
            System.out.println(map.get(key) + " " + key);
        }
    }
}

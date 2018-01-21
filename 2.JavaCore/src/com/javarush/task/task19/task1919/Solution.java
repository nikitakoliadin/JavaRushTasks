package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            TreeMap<String, Double> map = new TreeMap<String, Double>();
            String line;
            while (fileReader.ready() && (line = fileReader.readLine()) != null) {
                String[] nameAndValue = line.split(" ");

                if (map.containsKey(nameAndValue[0])) {
                    map.put(nameAndValue[0], map.get(nameAndValue[0]) + Double.parseDouble(nameAndValue[1]));
                } else {
                    map.put(nameAndValue[0], Double.parseDouble(nameAndValue[1]));
                }
            }

            for (Map.Entry<String, Double> pair : map.entrySet()) {
                System.out.println(pair.getKey() + " " + pair.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {

            Map <String, Double> map = new TreeMap<String, Double>();

            String line = "";
            while ((line = fileReader.readLine()) != null) {
                String[] nameAndValue = line.split(" ");

                if (map.containsKey(nameAndValue[0])) {
                    map.put(nameAndValue[0], map.get(nameAndValue[0]) + Double.parseDouble(nameAndValue[1]));
                } else {
                    map.put(nameAndValue[0], Double.parseDouble(nameAndValue[1]));
                }
            }

            double maxValue = 0;

            for (Map.Entry<String, Double> pair : map.entrySet()) {
                if (maxValue < pair.getValue()) {
                    maxValue = pair.getValue();
                }
            }

            for (Map.Entry<String, Double> pair : map.entrySet()) {
                if (maxValue == pair.getValue()) {
                    System.out.println(pair.getKey());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
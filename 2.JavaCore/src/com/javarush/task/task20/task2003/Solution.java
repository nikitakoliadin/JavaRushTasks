package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            try (InputStream inputStream = new FileInputStream(bufferedReader.readLine())) {

                load(inputStream);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties propertiesClass = new Properties();
        propertiesClass.putAll(properties);
        propertiesClass.store(outputStream, "my stream");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод

        Properties propertiesClass = new Properties();
        propertiesClass.load(inputStream);
        properties.putAll((Map) propertiesClass);
    }

    public static void main(String[] args) {

    }
}

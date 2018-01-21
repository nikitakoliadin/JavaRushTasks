package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static int count = 0;

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = bufferedReader.readLine();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {

                String line = "";
                while (reader.ready() && (line = reader.readLine()) != null) {
                    check(line);
                }

                System.out.println(count);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void check(String line) {
        Pattern pattern = Pattern.compile("\\bworld\\b");
        Matcher m = pattern.matcher(line);
        while (m.find()) {
            count++;
        }
    }
}
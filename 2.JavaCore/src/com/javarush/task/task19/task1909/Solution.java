package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            try (BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(bufferedReader.readLine()))) {

                String line = "";
                while (reader.ready() && (line = reader.readLine()) != null) {
                    String result = line.replaceAll("[.]","!");
                    writer.write(result);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

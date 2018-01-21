package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            try (BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
                 BufferedWriter fileWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine()))) {

                String line = "";
                while (fileReader.ready()
                        && (line = fileReader.readLine().replaceAll("\\p{Punct}", "")) != null) {
                    fileWriter.write(line);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]))) {

            String line;
            while ((line = fileReader.readLine()) != null) {
                String[] strings = line.split(" ");

                for (int i = 0; i < strings.length; i++) {
                    if (strings[i].matches(".*[\\d]+.*")) {
                        fileWriter.write(strings[i] + " ");
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

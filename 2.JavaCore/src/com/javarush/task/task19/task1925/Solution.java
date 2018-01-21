package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]))) {

            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while (fileReader.ready() && (line = fileReader.readLine()) != null) {
                String[] strings = line.split(" ");
                for (int i = 0; i < strings.length; i++) {
                    if (strings[i].length() > 6) {
                        stringBuilder.append(strings[i]).append(",");
                    }
                }
            }

            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());

            fileWriter.write(stringBuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

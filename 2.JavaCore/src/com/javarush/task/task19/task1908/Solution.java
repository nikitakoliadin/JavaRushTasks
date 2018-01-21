package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            try (BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
                 BufferedWriter fileWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine()))) {

                String line = "";
                while (fileReader.ready() && (line = fileReader.readLine()) != null) {
                    String[] strings = line.split(" ");
                    for (int i = 0; i < strings.length; i++) {
                        if(check(strings[i])) {
                            fileWriter.write(strings[i] + " ");
                        }
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean check(String line) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }
}

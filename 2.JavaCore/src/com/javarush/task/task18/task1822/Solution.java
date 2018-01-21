package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            try (BufferedReader fileReader =
                         new BufferedReader(
                                 new InputStreamReader(
                                         new FileInputStream(bufferedReader.readLine())))) {

                String line;
                while ((line = fileReader.readLine()) != null) {
                    if (line.substring(0, (line.indexOf(" "))).equals(args[0])) {
                        System.out.println(line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()))) {

            StringBuilder stringBuilder = new StringBuilder();

            while (fileReader.ready()) {
                stringBuilder.append(fileReader.readLine());
                System.out.println(stringBuilder.reverse());
                stringBuilder.delete(0, stringBuilder.length());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

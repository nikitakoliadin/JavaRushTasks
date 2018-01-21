package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {

            int countSymbol = 0;
            int countSpace = 0;
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                if ((char) data == ' ') {
                    countSpace++;
                }
                countSymbol++;
            }
            System.out.printf("%.2f",(1.0 * countSpace * 100 / countSymbol));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

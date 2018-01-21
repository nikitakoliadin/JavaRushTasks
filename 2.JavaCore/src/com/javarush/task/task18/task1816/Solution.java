package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {

            int count = 0;
            while (fileInputStream.available() > 0) {
                char c = (char) fileInputStream.read();
                if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                    count++;
                }
            }

            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

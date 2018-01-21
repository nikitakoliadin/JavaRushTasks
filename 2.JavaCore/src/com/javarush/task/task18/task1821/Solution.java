package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {

        try (FileInputStream fileInputStream = new FileInputStream(args[0])) { // try-with resources

            long[] bytes = new long[256];
            while (fileInputStream.available() > 0) {
                bytes[fileInputStream.read()]++;
            }

            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] != 0) {
                    System.out.println((char) i + bytes[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.javarush.task.task18.task1802;

import java.io.*;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try (FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {

                int minByte = Integer.MAX_VALUE;
                while (fileInputStream.available() > 0) {
                    int data = fileInputStream.read();
                    if (data < minByte) {
                        minByte = data;
                    }
                }
                System.out.println(minByte);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

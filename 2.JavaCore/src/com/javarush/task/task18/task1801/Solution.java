package com.javarush.task.task18.task1801;

import java.io.*;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try (FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {

                int maxByte = 0;
                while (fileInputStream.available() > 0) {
                    int data = fileInputStream.read();
                    if (data > maxByte) {
                        maxByte = data;
                    }
                }
                System.out.println(maxByte);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

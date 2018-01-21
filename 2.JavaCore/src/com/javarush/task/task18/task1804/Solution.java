package com.javarush.task.task18.task1804;

import java.io.*;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try (FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {

                byte[] bytes = new byte[256];
                while (fileInputStream.available() > 0) {
                    int data = fileInputStream.read();
                    bytes[data]++;
                }

                int minCount = Integer.MAX_VALUE;
                for (int i = 0; i < bytes.length; i++) {
                    if ((bytes[i] != 0) && (bytes[i]) < minCount) {
                        minCount = bytes[i];
                    }
                }

                for (int i = 0; i < bytes.length; i++) {
                    if (bytes[i] == minCount) {
                        System.out.print(i + " ");
                    }
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.javarush.task.task18.task1803;

import java.io.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try (FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {

                byte[] bytes = new byte[256];
                while (fileInputStream.available() > 0) {
                    int tmp = fileInputStream.read();
                    bytes[tmp] += 1;
                }

                int maxCount = 0;
                for (int i = 0; i < bytes.length; i++) {
                    if (bytes[i] > maxCount) {
                        maxCount = bytes[i];
                    }
                }

                for (int i = 0; i < bytes.length; i++) {
                    if (bytes[i] == maxCount) {
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

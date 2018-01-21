package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try {
                FileInputStream fileInputStream = new FileInputStream(reader.readLine());
                FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());
                try {

                    byte[] bytes = new byte[fileInputStream.available()];
                    fileInputStream.read(bytes);

                    for (int j = bytes.length - 1; j >= 0; j--) {
                        fileOutputStream.write(bytes[j]);
                    }

                } finally {
                    fileInputStream.close();
                    fileOutputStream.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

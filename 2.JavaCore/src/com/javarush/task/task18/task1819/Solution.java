package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String firstFile = bufferedReader.readLine();
            String secondFile = bufferedReader.readLine();
            try (FileInputStream fileInputStream = new FileInputStream(firstFile)) {

                byte[] bytes = new byte[fileInputStream.available()];
                int count = fileInputStream.read(bytes);

                FileOutputStream fileOutputStream = new FileOutputStream(firstFile);
                FileInputStream fileInputStream2 = new FileInputStream(secondFile);
                try {

                    while (fileInputStream2.available() > 0) {
                        int data = fileInputStream2.read();
                        fileOutputStream.write(data);
                    }

                    fileOutputStream.write(bytes, 0, count);

                } finally {
                    fileInputStream2.close();
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

package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try {
                FileInputStream fileInputStream = new FileInputStream(reader.readLine());
                FileOutputStream fileOutputStream1 = new FileOutputStream(reader.readLine());
                FileOutputStream fileOutputStream2 = new FileOutputStream(reader.readLine());
                try {
                    byte[] buffer;
                    if (fileInputStream.available() % 2 == 0) {
                        buffer = new byte[fileInputStream.available() / 2];
                    } else {
                        buffer = new byte[fileInputStream.available() / 2 + 1];
                    }
                    byte[] bufferEnd = new byte[fileInputStream.available() / 2];

                    while (fileInputStream.available() > 0) {
                        int count = fileInputStream.read(buffer);
                        fileOutputStream1.write(buffer, 0, count);
                        count = fileInputStream.read(bufferEnd);
                        fileOutputStream2.write(bufferEnd, 0, count);
                    }

                } finally {
                    fileInputStream.close();
                    fileOutputStream1.close();
                    fileOutputStream2.close();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

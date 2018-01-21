package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(bufferedReader.readLine());
                FileInputStream fileInputStream1 = new FileInputStream(bufferedReader.readLine());
                FileInputStream fileInputStream2 = new FileInputStream(bufferedReader.readLine());
                try {

                    while (fileInputStream1.available() > 0) {
                        int data = fileInputStream1.read();
                        fileOutputStream.write(data);
                    }

                    while (fileInputStream2.available() > 0) {
                        int data = fileInputStream2.read();
                        fileOutputStream.write(data);
                    }

                } finally {
                    fileOutputStream.close();
                    fileInputStream1.close();
                    fileInputStream2.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

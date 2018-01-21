package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try (FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {

                int count = 0;
                while (fileInputStream.available() > 0) {
                    int data = fileInputStream.read();
                    if (data == 44) {
                        count++;
                    }
                }

                System.out.println(count);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

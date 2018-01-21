package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            try (FileReader fileReader = new FileReader(bufferedReader.readLine());
                 FileWriter fileWriter = new FileWriter(bufferedReader.readLine())) {

                int count = 0;

                while (fileReader.ready()) {
                    int data = fileReader.read();
                    count++;
                    if (count % 2 == 0) {
                        fileWriter.write(data);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

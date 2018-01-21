package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String fileOutput = reader.readLine();
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOutput))) {

                String s;
                do {
                    s = reader.readLine();
                    bufferedWriter.write(s);
                    bufferedWriter.newLine();
                } while (!s.equals("exit"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

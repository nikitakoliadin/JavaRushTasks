package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            String fileName1 = bufferedReader.readLine();
            String fileName2 = bufferedReader.readLine();

            try (BufferedReader fileInputStream =
                         new BufferedReader(
                                 new InputStreamReader(
                                         new FileInputStream(fileName1)));
                 BufferedWriter fileOutputStream =
                         new BufferedWriter(
                                 new OutputStreamWriter(
                                         new FileOutputStream(fileName2)))) {

                String l;
                double d;
                while((l=fileInputStream.readLine())!=null) {
                    for(String s: l.split(" ")) {
                        d = Math.round(Double.parseDouble(s));
                        int a = (int) d;
                        fileOutputStream.write(a + " ");
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

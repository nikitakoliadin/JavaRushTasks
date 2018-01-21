package com.javarush.task.task18.task1805;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try (FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {

                Set<Byte> set = new TreeSet<Byte>();
                while (fileInputStream.available() > 0) {
                    set.add((byte) fileInputStream.read());
                }

                for (Byte b : set) {
                    System.out.print(b + " ");
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

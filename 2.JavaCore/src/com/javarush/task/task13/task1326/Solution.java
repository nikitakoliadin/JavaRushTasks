package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())))) {

                String line;
                while ((line = fileReader.readLine()) != null) {
                    list.add(Integer.valueOf(line));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        list.stream().filter(v -> v%2 == 0).sorted().forEach(System.out::println);
    }
}

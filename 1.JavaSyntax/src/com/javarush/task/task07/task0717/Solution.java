package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }
        ArrayList<String> result = doubleValues(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }




    }

    public static ArrayList doubleValues(ArrayList list) {
        int size = list.size();
        for (int i = 0, j = 0; j < size; i += 2, j++)
            list.add(i, list.get(i));
        return list;
    }
}

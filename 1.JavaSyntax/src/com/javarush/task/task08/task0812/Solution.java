package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(Integer.parseInt(reader.readLine()));
        }
        int[] countmas = new int[10];
        int count = 1;
        for (int i = 0; i < arrayList.size()-1; i++) {
            if (arrayList.get(i) == arrayList.get(i+1)) {
                count++;
                countmas[i] = count;
            }
            else {
                countmas[i] = 1;
                count = 1;
            }
        }
        int max = 0;
        for (int i = 0; i < countmas.length; i++) {
            if (countmas[i] > max)
                max = countmas[i];
        }
        System.out.println(max);
    }
}
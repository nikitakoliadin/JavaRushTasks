package com.javarush.task.task05.task0531;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Совершенствуем функциональность
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());

        int minimum = min(a, b, c, d, e);

        System.out.println("Minimum = " + minimum);
    }


    public static int min(int a, int b, int c, int d, int e) {
        int[] mas = new int[5];
        mas[0] = a;
        mas[1] = b;
        mas[2] = c;
        mas[3] = d;
        mas[4] = e;

        int min = mas[0];
        for(int i = 1; i < mas.length; i++) {
            if(mas[i] < min) {
                min = mas[i];
            }
        }

        return min;
    }
}

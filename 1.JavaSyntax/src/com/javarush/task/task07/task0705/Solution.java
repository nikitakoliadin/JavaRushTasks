package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] big = new int[20];
        int[] lit1 = new int[10];
        int[] lit2 = new int[10];

        for (int i = 0; i <big.length ; i++)
            big[i] = Integer.parseInt(reader.readLine());

        for (int i = 0; i <big.length ; i++) {
            if (i < 10)
                lit1[i] = big[i];
            else lit2[i-10] = big[i];
        }
        for (int i = 0; i <lit2.length ; i++)
            System.out.println(lit2[i]);
    }
}

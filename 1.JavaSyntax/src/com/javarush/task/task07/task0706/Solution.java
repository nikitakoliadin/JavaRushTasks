package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int[] arr = new int[15];

        for (int i = 0; i <arr.length ; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i <arr.length ; i++) {
            if (i%2==0)
                sum +=arr[i];
            else sum -= arr[i];
        }

        if (sum <0) System.out.println("В домах с нечетными номерами проживает больше жителей.");
        else System.out.println("В домах с четными номерами проживает больше жителей.");
    }
}

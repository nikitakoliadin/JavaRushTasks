package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(reader.readLine());
        int n2 = Integer.parseInt(reader.readLine());
        int n3 = Integer.parseInt(reader.readLine());
        int a=0,b=0;
        if (n1!=0) {
            if (n1 < 0) b++;
            else a++;
        }
        if (n2!=0) {
            if (n2 < 0) b++;
            else a++;
        }
        if (n3!=0) {
            if (n3 < 0) b++;
            else a++;
        }
        System.out.println("количество положительных чисел: " +a);
        System.out.println("количество отрицательных чисел: " +b);
    }
}

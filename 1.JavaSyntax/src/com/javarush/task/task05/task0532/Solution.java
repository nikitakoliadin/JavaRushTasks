package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N;
        do {
            N = Integer.parseInt(reader.readLine());
        } while(N <= 0);

        int[] mas = new int[N];

        for(int i = 0; i < mas.length; i++) {
                mas[i] = Integer.parseInt(reader.readLine());
        }

        int maximum = mas[0];
        for(Integer i : mas) {
            if(i > maximum) {
                maximum = i;
            }
        }

        System.out.println(maximum);
    }
}

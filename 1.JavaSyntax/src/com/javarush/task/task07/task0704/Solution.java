package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int IList[] = new int[10];
        for (int i = 0; i < IList.length; i++) {
            IList[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = (IList.length-1); i>=0; i--)

            System.out.println(IList[i]);

    }
}

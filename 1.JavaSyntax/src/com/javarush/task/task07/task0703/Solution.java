package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] SList = new String[10];
        int[] IList = new int[10];

        for (int i =0;i<SList.length;i++){
            SList[i] = reader.readLine();
        }
        for (int i = 0; i <IList.length ; i++) {
            IList[i] = SList[i].length();
            System.out.println(IList[i]);
        }
    }
}

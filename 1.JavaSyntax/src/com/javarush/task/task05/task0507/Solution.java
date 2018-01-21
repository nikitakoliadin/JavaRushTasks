package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        boolean b = true;
        int k =0;
        double n;
        while((n = Double.parseDouble(reader.readLine())) !=-1) {
            sum += n;
            k++;
        }

        System.out.println(sum/k);
    }
}


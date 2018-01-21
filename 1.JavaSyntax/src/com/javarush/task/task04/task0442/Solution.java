package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum =0;
        boolean b = true;
        while (b) {
            int n = Integer.parseInt(reader.readLine());
            sum = sum + n;
            if (n == -1){
                b=false;
            System.out.println(sum);
            }
        }
    }
}

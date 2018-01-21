package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(reader.readLine());
        int n2 = Integer.parseInt(reader.readLine());

        if (n1>0 && n2>0) System.out.println("1");
        else if (n1<0 && n2>0) System.out.println("2");
        else if (n1<0 && n2<0) System.out.println("3");
        else System.out.println("4");
    }
}

package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(reader.readLine());
        int n2 = Integer.parseInt(reader.readLine());
        int n3 = Integer.parseInt(reader.readLine());
        int n4 = Integer.parseInt(reader.readLine());

        if (max(n1,n2)>n3 && max(n1,n2)>n4) System.out.println(max(n1,n2));
        else if (n3 > n4) System.out.println(n3);
        else System.out.println(n4);
    }

    public static int max(int a, int b) {
        int max;
        if (a>b) max = a;
        else max = b;
        return max;
    }
}

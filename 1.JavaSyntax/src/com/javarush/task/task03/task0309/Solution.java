package com.javarush.task.task03.task0309;

/* 
Сумма 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        int a,b=0;
        for (int i=1; i<11;i++) {
            a = i + b;
            b = a;
            System.out.println(b);
        }
    }
}

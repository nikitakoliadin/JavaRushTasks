package com.javarush.task.task03.task0308;

/* 
Произведение 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(fack(10));
    }
    public static int fack(int i) {
        if ( i ==0 ) return 1;
        else return i*fack(i-1);
    }
}

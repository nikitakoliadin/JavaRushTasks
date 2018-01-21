package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {

    public  int intVar;
    public  double doubleVar;
    public  Double DoubleVar;
    public  boolean booleanVar;
    public  Object ObjectVar;
    public  Exception ExceptionVar;
    public  String StringVar;

    public static void main(String[] args) {
        System.out.print(new Solution().intVar + " ");
        System.out.print(new Solution().doubleVar + " ");
        System.out.print(new Solution().DoubleVar + " ");
        System.out.print(new Solution().booleanVar + " ");
        System.out.print(new Solution().ObjectVar + " ");
        System.out.print(new Solution().ExceptionVar + " ");
        System.out.print(new Solution().StringVar);
    }
}

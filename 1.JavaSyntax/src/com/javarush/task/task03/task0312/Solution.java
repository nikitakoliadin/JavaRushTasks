package com.javarush.task.task03.task0312;

/* 
Конвертируем время
*/

public class Solution {
    public static int convertToSeconds(int hour) {
        int convertToSeconds = 60*60*hour;
        return convertToSeconds;
    }

    public static void main(String[] args) {
        System.out.println(convertToSeconds(2));
        System.out.println(convertToSeconds(24));
    }
}

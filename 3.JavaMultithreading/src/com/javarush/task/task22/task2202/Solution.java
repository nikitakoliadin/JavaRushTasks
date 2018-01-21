package com.javarush.task.task22.task2202;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(getPartOfString("JavaRush - is the"));
    }

    public static String getPartOfString(String string) {
        if (string == null) {
            throw new TooShortStringException();
        }

        if (string.split(" ").length < 5) {
            throw new TooShortStringException();
        }

        String[] strings = string.split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < 5; i++) {
            stringBuilder.append(strings[i]).append(" ");
        }

        return stringBuilder.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}

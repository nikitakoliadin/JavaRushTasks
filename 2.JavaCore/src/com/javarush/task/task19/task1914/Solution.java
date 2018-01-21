package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        testString.printSomething();
        String result = byteArrayOutputStream.toString();
        System.setOut(consoleStream);

        String[] strings = result.split(" ");

        switch (strings[1]) {
            case "+": {
                int intResult = Integer.parseInt(strings[0]) + Integer.parseInt(strings[2]);
                System.out.printf("%s %s %s %s %s",strings[0], strings[1], strings[2], strings[3], intResult);
                break;
            }
            case "-": {
                int intResult = Integer.parseInt(strings[0]) - Integer.parseInt(strings[2]);
                System.out.printf("%s %s %s %s %s",strings[0], strings[1], strings[2], strings[3], intResult);
                break;
            }
            case "*": {
                int intResult = Integer.parseInt(strings[0]) * Integer.parseInt(strings[2]);
                System.out.printf("%s %s %s %s %s",strings[0], strings[1], strings[2], strings[3], intResult);
                break;
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}


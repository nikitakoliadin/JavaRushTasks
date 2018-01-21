package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        reset();
    }

    public static Flyable result;

    public static void reset() {
        String s = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            s = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (s.equals("helicopter")) {
            result = new Helicopter();
        } else if (s.equals("plane")) {
            result = new Plane(22);
        }
    }
}

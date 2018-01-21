package com.javarush.task.task22.task2210;

import java.util.Arrays;
import java.util.StringTokenizer;

/*
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTokens("level22.lesson13.task01", ".")));
    }
    public static String [] getTokens(String query, String delimiter) {

        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        String[] result = new String[stringTokenizer.countTokens()];

        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            result[i++] = stringTokenizer.nextToken();
        }

        return result;
    }
}

package com.javarush.task.task39.task3904;

import java.util.HashMap;
import java.util.Map;

/* 
Лестница
*/
public class Solution {
    private static int n = 70;

    static Map<Integer, Long> map = new HashMap<Integer, Long>(){{
        put(0, 1L);
        put(1, 1L);
        put(2, 2L);
        put(3, 4L);
    }};

    public static void main(String[] args) {
        System.out.println("Number of possible runups for " + n + " stairs is: " + countPossibleRunups(n));
    }

    public static long countPossibleRunups(int n) {
        if (n < 0) {
            return 0;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            long count = ((countPossibleRunups(n - 3) + countPossibleRunups(n - 2) + countPossibleRunups(n - 1)));

            map.put(n, count);

            return count;
        }


    }
}


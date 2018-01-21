package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();

        HashMap<String, Integer> monthColl = new HashMap<>();
        monthColl.put("January", 1);
        monthColl.put("February", 2);
        monthColl.put("March", 3);
        monthColl.put("April", 4);
        monthColl.put("May", 5);
        monthColl.put("June", 6);
        monthColl.put("July", 7);
        monthColl.put("August", 8);
        monthColl.put("September", 9);
        monthColl.put("October", 10);
        monthColl.put("November", 11);
        monthColl.put("December", 12);

        for(String key : monthColl.keySet()) {
            if (key.equals(month)) {
                System.out.println(month + " is " + monthColl.get(key) + " month");
            }
        }
    }
}

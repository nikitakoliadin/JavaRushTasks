package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String age1 = reader.readLine();
        String age2 = reader.readLine();

        System.out.println(name + " получает " + age1 + " через " + age2 + " лет. ");
    }
}

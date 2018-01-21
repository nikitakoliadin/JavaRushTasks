package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(n == 1 ? "понедельник": n == 2 ? "вторник": n==3 ? "среда": n==4 ? "четверг": n==5 ? "пятница": n==6 ? "суббота": n==7 ? "воскресенье" : "такого дня недели не существует");
    }
}
package com.javarush.task.task04.task0439;


import java.io.*;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        for (int i =1;i<=10;i++)
            System.out.println(name+" любит меня.");
    }
}

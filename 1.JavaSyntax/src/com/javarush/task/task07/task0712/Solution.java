package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }
        int max = 0;
        int min = 100;
        int maxInd = 0;
        int minInd = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > max) {
                max = list.get(i).length();
                maxInd = i;
            }

            if (list.get(i).length() < min) {
                min = list.get(i).length();
                minInd = i;
            }
        }

        if (maxInd > minInd)
            System.out.println(list.get(minInd));
        else if (maxInd < minInd)
            System.out.println(list.get(maxInd));
    }
}

package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
//        System.out.print("write x: ");
        int a = getInt();
//        System.out.print("Write y: ");
        int b = getInt();

        int nod = 0;
        int min;

        if (a < b) {
            min = a;
        } else {
            min = b;
        }

        int i = 1;

        while(true) {
            int c = a % i;
            int d = b % i;

            if ((c == 0) && (d == 0)) {
                nod = i;
                i++;
            } else {
                if ((c != 0) || (d != 0))
                    i++;
            }

            if ((i > min)) {
                System.out.println(nod);
                return ;
            }
        }
    }

    public static int getInt() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = null;
        int pickMenu;
        do {
            do {
                try {
                    inputString = reader.readLine();
                } catch (IOException e) {
                }
            }
            while (!inputString.matches("[-+]?\\d+"));
            pickMenu = Integer.parseInt(inputString);
        } while (pickMenu <= 0);
        return pickMenu;
    }
}

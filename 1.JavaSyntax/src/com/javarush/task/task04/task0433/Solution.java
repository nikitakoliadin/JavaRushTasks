package com.javarush.task.task04.task0433;


/* 
Гадание на долларовый счет
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int i=1;
        while (i<=100){
            System.out.print('S');
            if (i%10==0)
                System.out.println();
            i++;
        }
    }
}

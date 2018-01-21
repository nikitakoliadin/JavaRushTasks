package com.javarush.task.task04.task0437;


/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        int i = 1;
        int j = 0;
        for (; i <=10; i++){
            for (; j <= i; j++){
                if (j < i) System.out.print(8);
                else System.out.println();
            }
            j = 0;
        }
    }
}

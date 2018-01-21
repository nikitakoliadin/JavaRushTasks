package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String c = reader.readLine();
        char[] cToChar = c.toCharArray(); // переводим строку с в массив char
        for (char e : cToChar){ //цикл на определение гласных елементов
            if(isVowel(e)){
                System.out.print(e+" ");
            }
        }
        System.out.println();
        for (char e : cToChar){
            if(!isVowel(e)&(e!=' ')){
                System.out.print(e+" ");
            }
        }

    }
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
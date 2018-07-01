package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        try {
            int minRadix = 0;

            if (isNumber(args[0])) {
                for (int i = 2; i <= 36; i++) {
                    if (isRadix(args[0], i)) {
                        minRadix = i;
                        break;
                    }
                }
            }
            if (minRadix == 0) {
                System.out.println("incorrect");
            }
            else {
                System.out.println(minRadix);
            }
        } catch (Exception ignore) {
        }
    }

    private static boolean isRadix(String number, int radix) {
        try {
            new BigInteger(number, radix);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isNumber(String stringOfCharacters) {
        return stringOfCharacters.matches("[\\p{Digit}\\p{Alpha}]+");
    }
}
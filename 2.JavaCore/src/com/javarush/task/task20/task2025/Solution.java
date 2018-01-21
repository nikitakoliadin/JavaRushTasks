package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Алгоритмы-числа
*/

public class Solution {
    public static long[] getNumbers(long N) {

        int countOfNum = numLength(N);

        List<Long> list = ArmstrongNumbersMultiSetLongOpt.generate(countOfNum);

        return fromListToArray(list, N);

//        long[] result = new long[100];
//        int countResult = 0;
//
//        for (long i = 0; i < N; i++) {
//            long myNunSum = 0;
//            int countOfNum = (int) Math.ceil(Math.log10(i));
//
//            for (long j = i; j > 0 ; j/=10) {
//                myNunSum +=  Math.pow(j%10, countOfNum);
//            }
//
//            if (i == myNunSum) {
//                result[countResult++] = i;
//            }
//        }
//        return result;
    }

    public static long[] fromListToArray(List<Long> list, long N) {

        List<Long> list2 = new ArrayList<Long>();
        for (Long aList : list) {
            if (aList < N) {
                list2.add(aList);
            }
        }

        long[] array = new long[list2.size()];

        for (int i = 0; i < list2.size(); i++) {
            array[i] = list2.get(i);
        }

        return array;
    }

    public static int numLength(long num) {
        int length = 0;

        while (num > 0) {
            num /= 10;
            length++;
        }

        return length;
    }

    public static void main(String[] args) {
        System.out.println(getNumbers(Long.MAX_VALUE).length);
        System.out.println(Arrays.toString(getNumbers(8209)));
    }
}

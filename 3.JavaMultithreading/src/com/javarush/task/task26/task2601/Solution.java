package com.javarush.task.task26.task2601;

import java.util.Arrays;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {
        Integer[] copyArray = array;
        Arrays.sort(copyArray);

        int middle = (copyArray.length - 1) / 2;

        int median;

        if (copyArray.length % 2 == 0) {
            median = (copyArray[middle] + copyArray[middle + 1]) / 2;
        } else {
            median = copyArray[middle];
        }

        Arrays.sort(array, (o1, o2) -> {
            int distance1 = Math.abs(median - o1);
            int distance2 = Math.abs(median - o2);

            int result = Integer.compare(distance1, distance2);

            if (result != 0) {
                return result;
            } else {
                return Integer.compare(o1, o2);
            }
        });

        return array;
    }
}

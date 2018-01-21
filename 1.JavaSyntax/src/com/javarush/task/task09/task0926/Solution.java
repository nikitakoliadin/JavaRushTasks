package com.javarush.task.task09.task0926;

import java.util.ArrayList;
import java.util.Collections;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> list = new ArrayList<>();
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {18,6};
        int[] array3 = {7,8,9,10};
        int[] array4 = {11,12,13,14,15,16,17};
        int[] array5 = {};
        Collections.addAll(list,array1,array2,array3,array4,array5);
        return  list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}

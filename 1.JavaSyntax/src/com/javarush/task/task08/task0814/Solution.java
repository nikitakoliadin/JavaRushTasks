package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            set.add(i);
        }
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        HashSet<Integer> removes = new HashSet<Integer>();
        for(Integer number:set){
            if(number>10){
                removes.add(number);
            }
        }
        set.removeAll(removes);
        return set;
    }

    public static void main(String[] args) {


    }
}

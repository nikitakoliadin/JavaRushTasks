package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Set<Character> set = new TreeSet<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]))) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine().toLowerCase().replaceAll("[^\\p{Alpha}]", "");
                for (int i = 0; i < line.length(); i++) {
                    set.add(line.charAt(i));
                }
            }
        }

        int count = set.size() < 5 ? set.size() : 5;
        Iterator<Character> iterator = set.iterator();

        for (int i = 0; i < count; i++) {
            System.out.print(iterator.next());
        }
    }
}

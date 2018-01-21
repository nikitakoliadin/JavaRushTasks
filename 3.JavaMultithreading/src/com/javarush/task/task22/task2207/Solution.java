package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()))) {

            while (fileReader.ready()) {
                String string = fileReader.readLine();

                String[] strings = string.split(" ");

                list.addAll(Arrays.asList(strings));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        list.forEach(System.out::println);
        System.out.println();

        for (int i = 0; i < list.size() - 1; i++) {
            StringBuilder stringBuilder = new StringBuilder(list.get(i));
            for (int j = i + 1; j < list.size(); j++) {
                StringBuilder stringBuilder1 = new StringBuilder(list.get(j));
                if (stringBuilder.toString().equals(stringBuilder1.reverse().toString())) {

                    Pair pair = new Pair(stringBuilder.toString(), stringBuilder1.toString());

                    if (!result.contains(pair)) {
                        result.add(new Pair(stringBuilder.toString(), stringBuilder1.reverse().toString()));
                    }

                }
            }
        }

        result.forEach(System.out::println);
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }
}

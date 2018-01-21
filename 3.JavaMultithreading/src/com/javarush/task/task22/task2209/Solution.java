package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) {
        StringBuilder wordsLength = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()))) {

            while (fileReader.ready()) {
                wordsLength.append(fileReader.readLine()).append(" ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String s = wordsLength.toString();
        String[] words = s.split(" ");

        Arrays.sort(words);

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder();
        StringBuilder endLine = new StringBuilder();

        if (words.length == 0) {
            return result;
        }

        result.append(words[0]);
        words[0] = "";

        int count = 1;
        while (count < words.length) {
            int countHelp = count;
            for (int i = 0; i < words.length; i++) {
                if ((!words[i].equals("")) && result.charAt(result.length() - 1) == words[i].toLowerCase().charAt(0)) {
                    result.append(" ").append(words[i]);
                    words[i] = "";
                    count++;
                }
            }
            if (countHelp == count) { // если прошел весь цикл и слов найденно небыло
                for (int i = 0; i < words.length; i++) {
                    if (!endLine.toString().equals("")) {
                        endLine.append(" ").append(words[i]);
                        words[i] = "";
                        count++;
                    } else {
                        endLine.append(words[i]);
                        words[i] = "";
                        count++;
                    }
                }
            }
        }

        if (!endLine.toString().equals("")) {
            result.append(" ").append(endLine);
        }

        return result;
    }
}

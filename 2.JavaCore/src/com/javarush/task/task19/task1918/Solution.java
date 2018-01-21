package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            try (BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()))) {

                StringBuilder stringBuilder = new StringBuilder();
                while (fileReader.ready()) {
                    stringBuilder.append(fileReader.readLine());
                }

                findAndPrintTag(args[0], stringBuilder.toString(), 0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void findAndPrintTag(String tag, String string, int startInd) {
        Pattern pattern = Pattern.compile("<" + tag + ".*?>.*?(<" + tag + ".*?>.*?</" + tag + ">.*?)*</" + tag + ">");
        Matcher matcher = pattern.matcher(string);

        matcher.region(startInd, string.length());

        while (matcher.find()) {
            System.out.println(matcher.group());
            findAndPrintTag(tag, matcher.group(), 1);
        }
    }
}
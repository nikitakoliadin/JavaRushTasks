package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> list = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = bufferedReader.readLine();
            if (args[0].equals("-u")) {
                try (BufferedReader fileBufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(fileName)))) {

                    String line = "";

                    while((line = fileBufferedReader.readLine()) != null) { /* add to the list */
                        list.add(line);
                    }

                    for (String s : list) {
                        if (Integer.parseInt(s.substring(0, 8).trim()) == Integer.parseInt(args[1])) {
                            list.set(list.indexOf(s), formatString(args));
                        }
                    }

                    try (BufferedWriter fileBufferedWriter = new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(fileName)))) {

                        for (int i = 0; i < list.size(); i++) {
                            fileBufferedWriter.write(list.get(i));
                            if (i < list.size() - 1) {
                                fileBufferedWriter.newLine();
                            }

                        }
                    }
                }
            } else if (args[0].equals("-d")) {
                try (BufferedReader fileBufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(fileName)))) {

                    String line = "";

                    while((line = fileBufferedReader.readLine()) != null) {
                        list.add(line);
                    }

                    for (String s : list) {
                        if (Integer.parseInt(s.substring(0, 8).trim()) == Integer.parseInt(args[1])) {
                            list.remove(s);
                        }
                    }

                    try (BufferedWriter fileBufferedWriter = new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(fileName)))) {

                        for (int i = 0; i < list.size(); i++) {
                            fileBufferedWriter.write(list.get(i));
                            if (i < list.size() - 1) {
                                fileBufferedWriter.newLine();
                            }
                        }

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String formatString(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(args[1]); /* append Id */
        if (stringBuilder.length() < 8) {
            for (int i = 0, length = stringBuilder.length(); i < 8 - length; i++) {
                stringBuilder.append(" ");
            }
        }

        stringBuilder.append(args[2]); /* append productName */
        if (stringBuilder.length() < 38) {
            for (int i = 0, length = stringBuilder.length(); i < 38 - length; i++) {
                stringBuilder.append(' ');
            }
        }

        stringBuilder.append(args[3]); /* append price */
        if (stringBuilder.length() < 46) {
            for (int i = 0, length = stringBuilder.length(); i < 46 - length; i++) {
                stringBuilder.append(' ');
            }
        }

        stringBuilder.append(args[4]); /* append quantity */
        if (stringBuilder.length() < 50) {
            for (int i = 0, length = stringBuilder.length(); i < 50 - length; i++) {
                stringBuilder.append(' ');
            }
        }

        return stringBuilder.toString();
    }
}

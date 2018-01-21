package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = bufferedReader.readLine();
            if (args[0].equals("-c")) {
                try (BufferedReader fileBufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(fileName)));
                     BufferedWriter fileBufferedWriter = new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(fileName, true)))) {

                    int maxId = 0;
                    String line = "";

                    while((line = fileBufferedReader.readLine()) != null) { /* find max id in the file */
                        int foundId = Integer.parseInt(line.substring(0, 8).trim());
                        if(foundId > maxId ) {
                            maxId = foundId; // FIXME: 06.01.2018
                        }
                    }

                    fileBufferedWriter.write(formatString(args, ++maxId));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String formatString(String[] args, int id) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(id); /* append Id */
        if (stringBuilder.length() < 8) {
            for (int i = 0, length = stringBuilder.length(); i < 8 - length; i++) {
                stringBuilder.append(" ");
            }
        }

        stringBuilder.append(args[1]); /* append productName */
        if (stringBuilder.length() < 38) {
            for (int i = 0, length = stringBuilder.length(); i < 38 - length; i++) {
                stringBuilder.append(' ');
            }
        }

        stringBuilder.append(args[2]); /* append price */
        if (stringBuilder.length() < 46) {
            for (int i = 0, length = stringBuilder.length(); i < 46 - length; i++) {
                stringBuilder.append(' ');
            }
        }

        stringBuilder.append(args[3]); /* append quantity */
        if (stringBuilder.length() < 50) {
            for (int i = 0, length = stringBuilder.length(); i < 50 - length; i++) {
                stringBuilder.append(' ');
            }
        }

        return stringBuilder.toString();
    }
}

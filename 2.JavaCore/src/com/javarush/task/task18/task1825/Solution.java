package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName1 = reader.readLine();
            String fileName = fileName1.substring(0, fileName1.indexOf(".part"));
            File file = new File(fileName);
            file.createNewFile();

            try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileName))) {

                ArrayList<String> listOfFileNames = new ArrayList<>();
                while (!fileName1.equals("end")) {
                    listOfFileNames.add(fileName1);
                    fileName1 = reader.readLine();
                }
                Collections.sort(listOfFileNames);
                for (String s : listOfFileNames) {
                    BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(s));
                    while (inputStream.available() > 0) {
                        outputStream.write(inputStream.read());
                    }
                    inputStream.close();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

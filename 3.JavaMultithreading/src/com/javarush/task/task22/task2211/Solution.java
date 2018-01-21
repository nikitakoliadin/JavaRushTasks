package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "Windows-1251"));
             BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), "UTF-8"))) {

            String line;
            while (fileReader.ready() && (line = fileReader.readLine()) != null) {
                fileWriter.write(line);
                fileWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

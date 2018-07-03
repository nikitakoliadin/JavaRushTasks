package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String pathToFile = args[0];
        int number = Integer.parseInt(args[1]);
        String textToCompare = args[2];

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(pathToFile, "rw")) {
            randomAccessFile.seek(number);
            byte[] buffer = new byte[textToCompare.length()];
            randomAccessFile.read(buffer, 0 , textToCompare.length());

            String textFromFileToCompare = new String(buffer, Charset.defaultCharset());

            randomAccessFile.seek(randomAccessFile.length());

            if (textToCompare.equals(textFromFileToCompare)) {
                randomAccessFile.write("true".getBytes());
            } else {
                randomAccessFile.write("false".getBytes());
            }
        }
    }
}

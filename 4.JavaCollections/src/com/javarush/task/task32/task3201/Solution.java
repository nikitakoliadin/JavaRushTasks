package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        String pathToFile = args[0];
        int number = Integer.parseInt(args[1]);
        String textToWrite = args[2];

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(pathToFile, "rw")) {
            if (randomAccessFile.length() < number) {
                randomAccessFile.seek(randomAccessFile.length());
            } else {
                randomAccessFile.seek(number);
            }

            randomAccessFile.write(textToWrite.getBytes());
        }
    }
}

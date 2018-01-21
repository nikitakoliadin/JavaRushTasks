package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            FileInputStream fileInputStream = null;
            try {
                do {
                    fileInputStream = new FileInputStream(reader.readLine());
                } while (fileInputStream.available() >= 1000);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                fileInputStream.close();
                throw new DownloadException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class DownloadException extends Exception {

    }
}

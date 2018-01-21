package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            do {
                String fileName = bufferedReader.readLine();

                if (fileName.equals("exit")) {
                    break;
                }

                new ReadThread(fileName).start();

            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

                byte[] bytes = new byte[256];

                while (fileInputStream.available() > 0) {
                    bytes[fileInputStream.read()]++;
                }

                int countMaxByte = 0;
                int indexMaxByte = 0;

                for (int i = 0; i < bytes.length; i++) {
                    if (bytes[i] > countMaxByte) {
                        countMaxByte = bytes[i];
                        indexMaxByte = i;
                    }
                }

                resultMap.put(fileName, indexMaxByte);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

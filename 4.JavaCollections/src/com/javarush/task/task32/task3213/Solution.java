package com.javarush.task.task32.task3213;

import java.io.*;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringWriter stringWriter = new StringWriter();

        if (reader == null) {
            return stringWriter.toString();
        }

        try (BufferedReader bufferedReader = new BufferedReader(reader)) {

            byte[] bytesBuffer;

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bytesBuffer = line.getBytes();

                for (byte b : bytesBuffer) {
                    if (b == 32 || b == 10) {
                        stringWriter.write(b);
                    } else {
                        stringWriter.write(b + key);
                    }
                }
            }
        }

        return stringWriter.toString();
    }
}

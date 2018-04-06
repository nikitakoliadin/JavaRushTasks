package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream(args[1]);
             FileOutputStream fileOutputStream = new FileOutputStream(args[2])) {

            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);

            if (args[0].equals("-e")) {
                crypto(bytes);
            } else {
                crypto(bytes);
            }

            fileOutputStream.write(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // try (FileInputStream inputStream = new FileInputStream(args[1]);
        // 	 FileOutputStream outputStream = new FileOutputStream(args[2])) {


        //     while (inputStream.available() > 0) {
        //         byte[] a1 = new byte[inputStream.read()];

        //         if (args[0].equals("-e")) {
        //             byte[] result = java.util.Base64.getEncoder().encode(a1);
        //             outputStream.write(result);
        //         }
        //         if (args[0].equals("-d")) {
        //             byte[] result = java.util.Base64.getDecoder().decode(a1);
        //             outputStream.write(result);
        //         }
        //     }
        // }
    }

    private static void crypto(byte[] x) {
        byte temp=0;
        for(int i=0;i<x.length/2;i++){
            temp=x[i];
            x[i]=x[x.length-1-i];
            x[x.length-1-i]=temp;
        }
    }
}

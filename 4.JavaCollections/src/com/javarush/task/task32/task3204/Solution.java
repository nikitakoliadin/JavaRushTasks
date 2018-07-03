package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        String password;
        do {
            password = "";
            while (password.length() < 8) {
                int randomByte = (int) (Math.random() * 128);

                if ((randomByte > 47 && randomByte < 58)
                        || (randomByte > 64 && randomByte < 91)
                        || (randomByte > 96 && randomByte < 123)) {

                    password += (char) randomByte;
                }
            }
        } while (!(checkUpperCase(password) && checkLowerCase(password) && checkNumber(password)));

        byteArrayOutputStream.write(password.getBytes());

        return byteArrayOutputStream;
    }

    private static boolean checkUpperCase(String password) {
        return password.matches(".*\\p{Upper}.*");
    }

    private static boolean checkLowerCase(String password) {
        return password.matches(".*\\p{Lower}.*");
    }

    private static boolean checkNumber(String password) {
        return password.matches(".*\\p{Digit}.*");
    }
}

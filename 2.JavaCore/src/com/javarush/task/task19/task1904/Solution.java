package com.javarush.task.task19.task1904;


import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public void close() {
            fileScanner.close();
        }

        @Override
        public Person read() throws IOException {
            String[] strings = null;
            if (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                strings = line.split(" ");
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            Date date = null;
            try {
                date = dateFormat.parse(strings[3] + " " + strings[4] + " " + strings[5]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            assert strings != null;
            assert date != null;
            return  new Person(strings[1], strings[2], strings[0], date);
        }
    }
}

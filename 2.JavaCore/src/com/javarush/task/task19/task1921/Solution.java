package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {

            String line;

            while ((line = fileReader.readLine()) != null) {
                String[] strings = line.split(" ");

                StringBuilder nameBuilder = new StringBuilder();
                StringBuilder dateBuilder = new StringBuilder();
                for (int i = 0; i < strings.length; i++) {
                    if (!strings[i].matches("[+-]?\\d+")) {
                        nameBuilder.append(strings[i]).append(" ");
                    } else {
                        dateBuilder.append(strings[i]).append(" ");
                    }
                }

                Date date = new SimpleDateFormat("dd MM yyyy").parse(dateBuilder.toString().trim());
                PEOPLE.add(new Person(nameBuilder.toString().trim(), date));
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}

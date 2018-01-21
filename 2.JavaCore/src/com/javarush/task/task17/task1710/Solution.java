package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        if (args[0].equals("-c")) {
            if (args[2].equals("м")) {
                Person person = Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3]));
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            } else if (args[2].equals("ж")) {
                Person person = Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3]));
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            }
        } else if (args[0].equals("-u")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(args[2]);
            if(args[3].equals("м")) {
                person.setSex(Sex.MALE);
            } else if (args[3].equals("ж")) {
                person.setSex(Sex.FEMALE);
            }
            person.setBirthDay(new SimpleDateFormat("dd/MM/yyyy").parse(args[4]));
        } else if (args[0].equals("-d")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setBirthDay(null);
            person.setSex(null);
            person.setName(null);
        } else if (args[0].equals("-i")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            System.out.println(person.getName() + " " +
                    (person.getSex().equals(Sex.MALE) ? "м" : person.getSex().equals(Sex.FEMALE) ? "ж" : null) + " " +
                    new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDay()));
        }
    }
}

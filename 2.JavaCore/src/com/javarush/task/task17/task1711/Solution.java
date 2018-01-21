package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception{

        switch (args[0]) {
            case "-c": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i+=3) {
                        if (args[i+1].equals("м")) {
                            Person person = Person.createMale(args[i],
                                    new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i+2]));
                            allPeople.add(person);
                            System.out.println(allPeople.indexOf(person));
                        } else if (args[i+1].equals("ж")) {
                            Person person = Person.createFemale(args[i],
                                    new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i+2]));
                            allPeople.add(person);
                            System.out.println(allPeople.indexOf(person));
                        }
                    }
                }
                break;
            }
            case "-u": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i+=4) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(args[i+1]);
                        person.setBirthDay(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i+3]));
                        if(args[i+2].equals("м")) {
                            person.setSex(Sex.MALE);
                        } else if (args[i+2].equals("ж")) {
                            person.setSex(Sex.FEMALE);
                        }
                        person.setBirthDay(new SimpleDateFormat("dd/MM/yyyy").parse(args[i+3]));
                    }
                }
                break;
            }
            case "-d": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDay(null);
                    }
                }
                break;
            }
            case "-i": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        System.out.println(person.getName() + " " +
                                (person.getSex().equals(Sex.MALE)
                                        ? "м"
                                        : person.getSex().equals(Sex.FEMALE)
                                        ? "ж"
                                        : null) + " " +
                                new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDay()));
                    }
                }
                break;
            }
        }
    }
}

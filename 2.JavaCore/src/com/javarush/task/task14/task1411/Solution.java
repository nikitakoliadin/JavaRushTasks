package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key;
        List<String> keys = List.of("user", "loser", "coder", "proger");

        List<String> list = new ArrayList<String>();
        do {
            boolean flag = false;
            key = reader.readLine();
            for (String k : keys) {
                if (key.equals(k)) {
                    list.add(k);
                    flag = true;
                }
            }

            if (!flag) {
                break;
            }
        } while (true);

        for (String s : list) {
            if (s.equals("user")) {
                person = new Person.User();
            } else if (s.equals("loser")) {
                person = new Person.Loser();
            } else if (s.equals("coder")) {
                person = new Person.Coder();
            } else if (s.equals("proger")) {
                person = new Person.Proger();
            }

            doWork(person); //вызываем doWork

        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) {
            ((Person.User) person).live();
        } else if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        } else if (person instanceof Person.Coder) {
            ((Person.Coder) person).coding();
        } else if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
    }
}

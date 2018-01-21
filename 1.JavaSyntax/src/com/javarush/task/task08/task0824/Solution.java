package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList tmp = new ArrayList();
        Human child1 = new Human("ch1", false, 5, tmp);
        Human child2 = new Human("ch2", true, 3, tmp);
        Human child3 = new Human("ch3", false, 1, tmp);
        tmp.add(child1);tmp.add(child2);tmp.add(child3);
        Human father = new Human("f", true, 30, tmp );
        Human mother = new Human("m", false, 29, tmp );
        tmp.clear();tmp.add(father);
        Human grandfather1 = new Human("gf1", true, 65, tmp );
        Human grandmother1 = new Human("gm1", false, 53, tmp );
        tmp.clear();tmp.add(mother);
        Human grandfather2 = new Human("gf2", true, 60, tmp );
        Human grandmother2 = new Human("gm2", false, 57, tmp );
        System.out.println(grandfather1.toString());
        System.out.println(grandfather2.toString());
        System.out.println(grandmother1.toString());
        System.out.println(grandmother2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human (String name, boolean sex, int age, ArrayList children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = (ArrayList)children.clone();
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}

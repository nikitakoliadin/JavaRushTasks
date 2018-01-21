package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        Human father1 = new Human("M", true, 21);
        Human mother1 = new Human("F", false, 21);
        Human father2 = new Human("M1", true, 21);
        Human mother2 = new Human("F1", false, 21);
        Human father3 = new Human("M3", true, 21, father1, mother1);
        Human mother3 = new Human("F3", false, 21, father2, mother2);
        Human child1 = new Human("Kate", false, 21, father3, mother3);
        Human child2 = new Human("Pol", true, 2, father3, mother3);
        Human child3 = new Human("Kol", true, 1, father3, mother3);
        list.add(father1);
        list.add(mother1);
        list.add(father2);
        list.add(mother2);
        list.add(father3);
        list.add(mother3);
        list.add(child1);
        list.add(child2);
        list.add(child3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static class Human {
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}























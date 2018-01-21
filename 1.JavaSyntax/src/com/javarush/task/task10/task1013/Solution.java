package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private int age ;
        private String name = null;
        private String surrname = null;
        private char sex;
        private float size;
        private float weight;

        public Human(){

        }

        public Human(int age) {
            this.age = age;
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(char sex) {
            this.sex = sex;
        }

        public Human(float size) {
            this.size = size;
        }

        public Human(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public Human(int age, String name, String surrname) {
            this.age = age;
            this.name = name;
            this.surrname = surrname;
        }

        public Human(int age, String name, String surrname, char sex) {
            this.age = age;
            this.name = name;
            this.surrname = surrname;
            this.sex = sex;
        }

        public Human(int age, String name, String surrname, char sex, float size) {
            this.age = age;
            this.name = name;
            this.surrname = surrname;
            this.sex = sex;
            this.size = size;
        }

        public Human(int age, String name, String surrname, char sex, float size, float weight) {
            this.age = age;
            this.name = name;
            this.surrname = surrname;
            this.sex = sex;
            this.size = size;
            this.weight = weight;
        }
    }
}

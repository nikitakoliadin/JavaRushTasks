package com.javarush.task.task05.task0509;

/* 
Создать класс Friend
*/

public class Friend {
    public static void main(String[] args) {
    }
    private String name ;
    private int age ;
    private char sex ;

    public void initialize(String name){
        this.name = name;
    }
    public void initialize(String name,int age) {
        this.name = name;
        this.age = age;
    }
    public void initialize(String name,int age,char sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}

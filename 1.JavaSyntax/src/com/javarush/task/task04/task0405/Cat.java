package com.javarush.task.task04.task0405;

/* 
Реализовать метод setCatsCount
*/

public class Cat {
    private static int catsCount = 0;

    public static void setCatsCount(int catsCount) {
        Cat.catsCount = catsCount;
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setCatsCount(15);
        System.out.println(catsCount);
        cat.setCatsCount(25);
        System.out.println(catsCount);
    }
}

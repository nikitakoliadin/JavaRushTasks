package com.javarush.task.task04.task0404;

/* 
Реализовать метод addNewCat
*/

public class Cat {
    private static int catsCount = 0;

    public static void addNewCat() {
        Cat.catsCount = Cat.catsCount +1;
    }

    public static void main(String[] args) {

        Cat cat1 = new Cat();
        cat1.catsCount++;

        Cat cat2 = new Cat();
        cat2.catsCount++;
        Cat cat3 = new Cat();
        cat3.catsCount++;

        System.out.println("Cats count is " + Cat.catsCount);
    }
}

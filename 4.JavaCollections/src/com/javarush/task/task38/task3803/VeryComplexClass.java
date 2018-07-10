package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object object = new Character('!');
        System.out.println((Byte)object);
    }

    public void methodThrowsNullPointerException() {
        Integer integer = null;
        System.out.println(integer.toString());
    }

    public static void main(String[] args) {

    }
}

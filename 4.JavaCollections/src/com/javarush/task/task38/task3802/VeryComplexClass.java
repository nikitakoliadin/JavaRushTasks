package com.javarush.task.task38.task3802;

import java.io.FileReader;

/*
Проверяемые исключения (checked exception)
*/
public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        FileReader fileReader = new FileReader("FuckMyDick");
    }

    public static void main(String[] args) {

    }
}

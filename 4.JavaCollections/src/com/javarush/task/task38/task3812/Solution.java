package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        PrepareMyTest prepareMyTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);

        if (prepareMyTest != null) {
            System.out.println(Arrays.toString(prepareMyTest.fullyQualifiedNames()));
            return true;
        } else {
            return false;
        }
    }

    public static boolean printValues(Class c) {
        PrepareMyTest prepareMyTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);

        if (prepareMyTest != null) {
            System.out.println(Arrays.toString(prepareMyTest.value()));
            return true;
        } else {
            return false;
        }
    }
}

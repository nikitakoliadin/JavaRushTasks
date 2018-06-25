package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            wheels =  new LinkedList<>();

            final String[] mockWheelsFromDB = loadWheelNamesFromDB();

            if (mockWheelsFromDB.length != 4) {
                throw new IllegalArgumentException();
            }

            for (String mockWheel: mockWheelsFromDB) {
                try {
                    wheels.add(Wheel.valueOf(mockWheel));
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }

        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        System.out.println(new Car().wheels);
    }
}

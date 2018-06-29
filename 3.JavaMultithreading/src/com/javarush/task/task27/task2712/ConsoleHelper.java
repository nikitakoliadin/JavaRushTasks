package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> orderDishes = new ArrayList<>();

        writeMessage(Dish.allDishesToString());
        writeMessage("Select dishes:");

        String selectedDish = null;

        while(!(selectedDish = readString()).equals("exit")) {
            try {
                orderDishes.add(Dish.valueOf(selectedDish));
            } catch (Exception e) {
                writeMessage("Dish not exist! Select another one!");
            }
        }

        return orderDishes;
    }
}

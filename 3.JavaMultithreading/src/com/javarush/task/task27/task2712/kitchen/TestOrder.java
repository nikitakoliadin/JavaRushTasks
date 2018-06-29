package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() {
        int numberOfRandomDishes = (int) (Math.random() * Dish.values().length);

        List<Dish> randomDishList = new ArrayList<>();

        for (int i = 0; i < numberOfRandomDishes; i++) {
            int numberOfRandomDish = (int) (Math.random() * Dish.values().length);
            randomDishList.add(Dish.values()[numberOfRandomDish]);
        }

        dishes = randomDishList;
    }
}

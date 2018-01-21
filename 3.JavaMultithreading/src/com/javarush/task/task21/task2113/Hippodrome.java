package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        horses.forEach(Horse::print);

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Horse getWinner() {
        return horses.stream().max(Comparator.comparingDouble(Horse::getDistance)).get();
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {
        List<Horse> listHorse = new ArrayList<Horse>();

        Horse horse1 = new Horse("FirstHorse", 3, 0);
        Horse horse2 = new Horse("SecondHorse", 3, 0);
        Horse horse3 = new Horse("ThirdHorse", 3, 0);

        listHorse.add(horse1);
        listHorse.add(horse2);
        listHorse.add(horse3);

        game = new Hippodrome(listHorse);

        game.run();
        game.printWinner();
    }
}

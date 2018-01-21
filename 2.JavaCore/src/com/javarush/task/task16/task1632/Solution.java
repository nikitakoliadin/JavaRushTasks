package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread(new FirstThread()));
        threads.add(new Thread(new SecondThread()));
        threads.add(new Thread(new ThirdThread()));
        threads.add(new FourthThread());
        threads.add(new Thread(new FifthThread()));
    }

    public static void main(String[] args) {
        for (Thread thread : threads) {
            thread.start();
        }

//        System.out.println(threads.get(3).isAlive());
    }

    public static class FirstThread implements Runnable {

        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class SecondThread implements Runnable {

        @Override
        public void run() {
            try {
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class ThirdThread implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {

            }
        }
    }

    public static class FourthThread extends Thread implements Message {

        @Override
        public void showWarning() {
            interrupt();
        }

        @Override
        public void run() {
            showWarning();
        }
    }

    public static class FifthThread implements Runnable {

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                int sum = 0;
                String s = "";

                do {
                    s = reader.readLine();
                    if (s.equals("N")) {
                        break;
                    }
                    sum += Integer.parseInt(s);
                } while (true);

                System.out.println(sum);
            } catch (IOException e) {

            }
        }
    }
}
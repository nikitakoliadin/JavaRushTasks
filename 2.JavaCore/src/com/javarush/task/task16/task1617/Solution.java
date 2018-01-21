package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();

    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
//            if (countSeconds < 3.5) {
//                for (int i = countSeconds; i >= 0; i--) {
//                    try {
//                        if (countSeconds == 0) {
//                            System.out.print("Марш!");
//                        } else {
//                            System.out.print(countSeconds + " ");
//                        }
//                        countSeconds--;
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                    }
//                }
//            }  else {
//                for (int i = countSeconds; i >= 1; i--) {
//                    try {
//                        System.out.print(countSeconds + " ");
//                        countSeconds--;
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        System.out.print("Прервано!");
//                    }
//                }
//            }

            Thread current = Thread.currentThread();

            while (!current.isInterrupted()) {
                try {
                    if (countSeconds == 0) {
                        System.out.print("Марш!");
                        break;
                    } else {
                        System.out.print(countSeconds-- + " ");
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.print("Прервано!");
                    break;
                }
            }
        }
    }
}

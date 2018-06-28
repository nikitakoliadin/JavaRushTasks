package com.javarush.task.task28.task2802;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {

    public static void main(String[] args) {
        class EmulateThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulateThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulateThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {

        private static volatile AtomicInteger factoryCounter = new AtomicInteger(0);
        private volatile AtomicInteger threadGroupNumber = new AtomicInteger(0);

        private final int factoryNumber;

        public AmigoThreadFactory() {
            factoryNumber = factoryCounter.incrementAndGet();
        }

        @Override
        public Thread newThread(Runnable r) {
            String threadName = String.format("%s-pool-%d-thread-%d",
                    Thread.currentThread().getThreadGroup().getName(),
                    factoryNumber,
                    threadGroupNumber.incrementAndGet()
            );


            Thread thread = new Thread(r, threadName);

            thread.setDaemon(false);
            thread.setPriority(Thread.NORM_PRIORITY);


            return thread;
        }
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }
}

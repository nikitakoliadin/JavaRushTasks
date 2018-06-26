package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        AtomicInteger i = new AtomicInteger(0);
        while (!currentThread.isInterrupted()) {
            map.put(String.valueOf(i.incrementAndGet()), String.format("Some text for %d", i.get()));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(String.format("%s thread was terminated", currentThread.getName()));
            }
        }
    }
}

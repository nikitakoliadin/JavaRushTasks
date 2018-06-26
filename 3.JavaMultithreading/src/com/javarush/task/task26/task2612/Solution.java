package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        //implement logic here, use the lock field
        boolean isLocked = lock.tryLock();
        try {
            if (isLocked) {
                ifLockIsFree();
            } else {
                ifLockIsBusy();
            }
        } finally {
            if (isLocked) {
                lock.unlock();
            }
        }
    }

    public void ifLockIsFree() {
    }

    public void ifLockIsBusy() {
    }
}

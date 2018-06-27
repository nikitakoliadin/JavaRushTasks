package com.javarush.task.task27.task2707;

import static java.lang.Thread.State.BLOCKED;
import static java.lang.Thread.State.TERMINATED;

/*
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        Thread thread = new Thread(() -> solution.someMethodWithSynchronizedBlocks(o1, o2));

        synchronized (o2) {
            thread.start();
            while (thread.getState() != BLOCKED) {
            }
        }

        synchronized (o1) {
            thread.join(100);
            return thread.getState() == TERMINATED;
        }
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}

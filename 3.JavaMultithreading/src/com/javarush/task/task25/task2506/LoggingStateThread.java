package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {

    private Thread threadState;

    public LoggingStateThread(Thread threadState) {
        this.threadState = threadState;
        setDaemon(true);
    }

    @Override
    public void run() {
        State previousState = null;

        do {
            if (previousState != threadState.getState()) {
                previousState = threadState.getState();
                System.out.println(threadState.getState());
            }
        } while (threadState.getState() != State.TERMINATED);
    }
}

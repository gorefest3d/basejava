package com.urise.webapp;

public class MainDeadlock {
    public static void main(String[] args) {
        final Object ONE = "lock1";
        final Object TWO = "lock2";
        deadLock(ONE, TWO);
        deadLock(TWO, ONE);

    }

    private static void deadLock(Object one, Object two) {
        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " Waiting " + one);
            synchronized (one) {
                System.out.println(threadName + " Holding " + one);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadName + " Waiting " + two);
                synchronized (two) {
                    System.out.println(threadName + " Holding " + two);
                }
            }
        }).start();
    }
}

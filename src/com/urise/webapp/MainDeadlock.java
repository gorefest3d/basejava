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
            System.out.println(getThreadName() + " Waiting " + one);
            synchronized (one) {
                System.out.println(getThreadName() + " Holding " + one);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getThreadName() + " Waiting " + two);
                synchronized (two) {
                    System.out.println(getThreadName() + " Holding " + two);
                }
            }
        }).start();
    }

    private static String getThreadName() {
        return Thread.currentThread().getName();
    }
}

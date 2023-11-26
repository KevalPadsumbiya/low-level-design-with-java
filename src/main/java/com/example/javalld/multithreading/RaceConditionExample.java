package com.example.javalld.multithreading;

class Counter {
    int count;

    synchronized void increaseCount() {
        this.count++;
    }
}

public class RaceConditionExample {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable runnableA = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increaseCount();
            }
        };

        Runnable runnableB = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increaseCount();
            }
        };

        Thread threadA = new Thread(runnableA);
        Thread threadB = new Thread(runnableB);

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        threadA.notify();
        System.out.println(counter.count);
    }
}

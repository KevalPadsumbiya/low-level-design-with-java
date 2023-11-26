package com.example.javalld.multithreading;

class Process {
    Integer count = 0;

    public void increaseCount(int threadNo) throws InterruptedException {
        if (threadNo == 2) {
            System.out.println("Before waiting!");
            count.wait(1000);
            System.out.println("After waiting!");
            count.notify();
        }
    }
}

public class WaitExample {

    public static void main(String[] args) throws InterruptedException {
        Process process = new Process();

        Runnable runnableA = () -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    process.increaseCount(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable runnableB = () -> {
            for (int i = 0; i < 1; i++) {
                try {
                    process.increaseCount(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread threadA = new Thread(runnableA);
        Thread threadB = new Thread(runnableB);

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();
    }
}

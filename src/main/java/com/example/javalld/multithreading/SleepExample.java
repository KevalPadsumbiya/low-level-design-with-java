package com.example.javalld.multithreading;

class Incrementor {
    int count;

    public synchronized void increaseCounter(int threadNo) throws InterruptedException {
        System.out.println(String.format("Thread %s is incrementation count %s by 1", threadNo, count));
        this.count++;
        if (threadNo == 2) {
            System.out.println("Thread 2 is sleeping for 10 seconds!");
            Thread.sleep(10000);
        }
    }
}

public class SleepExample {

    public static void main(String[] args) throws InterruptedException {
        Incrementor incrementor = new Incrementor();

        Runnable runnableA = () -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    incrementor.increaseCounter(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable runnableB = () -> {
            int done = 0;
            for (int i = 0; i < 1000; i++) {
                try {
                    if (done == 0) {
                        incrementor.increaseCounter(2);
                        done = 1;
                    } else {
                        incrementor.increaseCounter(3);
                    }
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

package com.example.javalld.multithreading;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnableA = () -> {
            System.out.println("Inside runnableA's run method");
            for (int i = 1; i < 5; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    //pass
                }
            }
        };

        Runnable runnableB = () -> {
            System.out.println("Inside runnableB's run method");
            for (int i = 1; i < 5; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    //pass
                }
            }
        };

        Thread threadA = new Thread(runnableA);
        Thread threadB = new Thread(runnableB);

//        threadA.setPriority(10);
//        threadB.setPriority(1);

        threadA.start();
        threadA.join();

        threadB.start();
        threadB.join();
    }
}

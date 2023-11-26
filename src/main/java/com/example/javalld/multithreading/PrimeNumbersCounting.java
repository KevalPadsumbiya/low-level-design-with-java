package com.example.javalld.multithreading;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class PrimeNumbersCounting {

    public static int totalPrimeNumbers;

    public static void main(String[] args) throws InterruptedException {
        totalPrimeNumbers = 0;
        List<Runnable> runnableList = getRunnables();

        List<Thread> threads = new ArrayList<>();

        for (Runnable runnable : runnableList) {
            threads.add(new Thread(runnable));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) { // let main thread wait until all thread completes
            thread.join();
        }

        log.info("Total prime numbers: {}", totalPrimeNumbers);

        totalPrimeNumbers = 0;
        log.info("Starting normally at {}", Instant.now());
        Instant start = Instant.now();

        for (int i = 1; i <= 100000000; i++) {
            if (isPrime(i)) {
                incrementTotalPrimeNumbers();
            }

        }
        log.info("Completed normally in {} seconds", Duration.between(start, Instant.now()).toSeconds());
    }

    public static synchronized void incrementTotalPrimeNumbers() {
        totalPrimeNumbers++;
    }

    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        // Check from 2 to square root of n
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0)
                return false;
        return true;
    }

    public static List<Runnable> getRunnables() {
        Runnable runnable1 = () -> {
            log.info("Starting thread 1 at {}", Instant.now());
            Instant start = Instant.now();
            for (int i = 1; i <= 10000000; i++) {
                if (isPrime(i)) {
                    incrementTotalPrimeNumbers();
                }
            }
            log.info("Thread 1 completed in {} seconds", Duration.between(start, Instant.now()).toSeconds());
        };

        Runnable runnable2 = () -> {
            log.info("Starting thread 2 at {}", Instant.now());
            Instant start = Instant.now();
            for (int i = 10000001; i <= 20000000; i++) {
                if (isPrime(i)) {
                    incrementTotalPrimeNumbers();
                }
            }
            log.info("Thread 2 completed in {} seconds", Duration.between(start, Instant.now()).toSeconds());

        };

        Runnable runnable3 = () -> {
            log.info("Starting thread 3 at {}", Instant.now());
            Instant start = Instant.now();
            for (int i = 20000001; i <= 30000000; i++) {
                if (isPrime(i)) {
                    incrementTotalPrimeNumbers();
                }
            }
            log.info("Thread 3 completed in {} seconds", Duration.between(start, Instant.now()).toSeconds());
        };

        Runnable runnable4 = () -> {
            log.info("Starting thread 4 at {}", Instant.now());
            Instant start = Instant.now();
            for (int i = 30000001; i <= 40000000; i++) {
                if (isPrime(i)) {
                    incrementTotalPrimeNumbers();
                }
            }
            log.info("Thread 4 completed in {} seconds", Duration.between(start, Instant.now()).toSeconds());
        };

        Runnable runnable5 = () -> {
            log.info("Starting thread 5 at {}", Instant.now());
            Instant start = Instant.now();
            for (int i = 40000001; i <= 50000000; i++) {
                if (isPrime(i)) {
                    incrementTotalPrimeNumbers();
                }
            }
            log.info("Thread 5 completed in {} seconds", Duration.between(start, Instant.now()).toSeconds());
        };

        Runnable runnable6 = () -> {
            log.info("Starting thread 6 at {}", Instant.now());
            Instant start = Instant.now();
            for (int i = 50000001; i <= 60000000; i++) {
                if (isPrime(i)) {
                    incrementTotalPrimeNumbers();
                }
            }
            log.info("Thread 6 completed in {} seconds", Duration.between(start, Instant.now()).toSeconds());
        };

        Runnable runnable7 = () -> {
            log.info("Starting thread 7 at {}", Instant.now());
            Instant start = Instant.now();
            for (int i = 60000001; i <= 70000000; i++) {
                if (isPrime(i)) {
                    incrementTotalPrimeNumbers();
                }
            }
            log.info("Thread 7 completed in {} seconds", Duration.between(start, Instant.now()).toSeconds());
        };

        Runnable runnable8 = () -> {
            log.info("Starting thread 8 at {}", Instant.now());
            Instant start = Instant.now();
            for (int i = 70000001; i <= 80000000; i++) {
                if (isPrime(i)) {
                    incrementTotalPrimeNumbers();
                }
            }
            log.info("Thread 8 completed in {} seconds", Duration.between(start, Instant.now()).toSeconds());
        };

        Runnable runnable9 = () -> {
            log.info("Starting thread 9 at {}", Instant.now());
            Instant start = Instant.now();
            for (int i = 80000001; i <= 90000000; i++) {
                if (isPrime(i)) {
                    incrementTotalPrimeNumbers();
                }
            }
            log.info("Thread 9 completed in {} seconds", Duration.between(start, Instant.now()).toSeconds());
        };

        Runnable runnable10 = () -> {
            log.info("Starting thread 10 at {}", Instant.now());
            Instant start = Instant.now();
            for (int i = 90000001; i <= 100000000; i++) {
                if (isPrime(i)) {
                    incrementTotalPrimeNumbers();
                }
            }
            log.info("Thread 10 completed in {} seconds", Duration.between(start, Instant.now()).toSeconds());
        };

        return Arrays.asList(
                runnable1,
                runnable2,
                runnable3,
                runnable4,
                runnable5,
                runnable6,
                runnable7,
                runnable8,
                runnable9,
                runnable10
        );
    }
}

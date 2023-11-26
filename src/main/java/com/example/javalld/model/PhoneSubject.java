package com.example.javalld.model;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class PhoneSubject implements Subject {
    private List<Observer> observerList;
    private boolean available;
    private String message;

    public PhoneSubject() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (Objects.isNull(observer)) {
            log.error("Cannot register observer!");
            throw new NullPointerException("Cannot register observer!");
        }

        if (!observerList.contains(observer)) {
            this.observerList.add(observer);
        }
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            log.info("Notifying {}", observer.getObserverName());
        }

        this.available = false;
    }

    @Override
    public String getUpdate() {
        return this.message;
    }

    public void makeItAvailable(String message) {
        log.info(message);
        this.available = true;
        notifyObservers();
    }
}

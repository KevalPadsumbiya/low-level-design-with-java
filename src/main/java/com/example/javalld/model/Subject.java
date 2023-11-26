package com.example.javalld.model;

public interface Subject {
    public void registerObserver(Observer observer);

    public void unregisterObserver(Observer observer);

    public void notifyObservers();

    public Object getUpdate();
}

package com.example.javalld.model;

public interface Observer {
    public void update();

    public void setSubject(Subject subject);

    public Object getObserverName();
}

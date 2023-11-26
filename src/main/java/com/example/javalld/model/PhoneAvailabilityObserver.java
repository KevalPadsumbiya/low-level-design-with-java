package com.example.javalld.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PhoneAvailabilityObserver implements Observer {
    String name;
    Subject phone;

    public PhoneAvailabilityObserver(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        String message = (String) phone.getUpdate();
        if (message == null) {
            log.info("{} :: phone is not available yet!", this.name);
        } else {
            log.info("{} notified from phone subject!", this.name);
        }
    }

    @Override
    public void setSubject(Subject phone) {
        this.phone = phone;
    }

    @Override
    public String getObserverName() {
        return this.name;
    }
}

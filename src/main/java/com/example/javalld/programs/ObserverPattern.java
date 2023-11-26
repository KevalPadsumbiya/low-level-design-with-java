package com.example.javalld.programs;

import com.example.javalld.model.PhoneAvailabilityObserver;
import com.example.javalld.model.PhoneSubject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObserverPattern {

    public static void main(String[] args) {
        PhoneSubject phoneSubject = new PhoneSubject();
        PhoneAvailabilityObserver phoneAvailabilityObserver1 = new PhoneAvailabilityObserver("Keval");
        PhoneAvailabilityObserver phoneAvailabilityObserver2 = new PhoneAvailabilityObserver("Amit");
        PhoneAvailabilityObserver phoneAvailabilityObserver3 = new PhoneAvailabilityObserver("Ravi");
        PhoneAvailabilityObserver phoneAvailabilityObserver4 = new PhoneAvailabilityObserver("Vivek");

        phoneSubject.registerObserver(phoneAvailabilityObserver1);
        phoneSubject.registerObserver(phoneAvailabilityObserver2);
        phoneSubject.registerObserver(phoneAvailabilityObserver3);
        phoneSubject.registerObserver(phoneAvailabilityObserver4);

        phoneAvailabilityObserver1.setSubject(phoneSubject);
        phoneAvailabilityObserver2.setSubject(phoneSubject);
        phoneAvailabilityObserver3.setSubject(phoneSubject);
        phoneAvailabilityObserver4.setSubject(phoneSubject);

        phoneAvailabilityObserver1.update();

        phoneSubject.makeItAvailable("Phone is available now!");
    }
}

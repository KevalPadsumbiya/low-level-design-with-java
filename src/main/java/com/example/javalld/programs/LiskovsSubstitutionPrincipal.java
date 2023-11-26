package com.example.javalld.programs;

import com.example.javalld.model.Bicycle;
import com.example.javalld.model.Bike;
import com.example.javalld.model.Car;
import com.example.javalld.model.Vehicle;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Liskov's substitution principal states that if class B is subtype of class A then we should be able to replace A's object with
 * B's object without disrupting the behaviour of the program
 */

@Slf4j
public class LiskovsSubstitutionPrincipal {

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car());
        vehicles.add(new Bike());
        vehicles.add(new Bicycle());

        for (Vehicle vehicle : vehicles) {
            log.info(vehicle.noOfWheels() + " " + vehicle.hasEngine());
        }
    }
}

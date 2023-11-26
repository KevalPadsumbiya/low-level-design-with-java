package com.example.javalld.builderpattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainClass {
    public static void main(String[] args) {
        Employee employee = new Employee.Builder()
                .setName("Keval")
                .setAge(20)
                .setExperience(2)
                .setDesignation("Software Engineer 1")
                .build();

        log.info(employee.toString());
    }
}

package com.example.javalld.builderpattern;

public class Employee {
    String employeeName;
    String employeeDesignation;
    int employeeAge;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeDesignation='" + employeeDesignation + '\'' +
                ", employeeAge=" + employeeAge +
                ", employeeExperience=" + employeeExperience +
                '}';
    }

    int employeeExperience;

    public Employee(Builder builder) {
        this.employeeName = builder.employeeName;
        this.employeeDesignation = builder.employeeDesignation;
        this.employeeAge = builder.employeeAge;
        this.employeeExperience = builder.employeeExperience;
    }

    public static class Builder {
        String employeeName;
        String employeeDesignation;
        int employeeAge;
        int employeeExperience;

        public static Builder builder() {
            return new Builder();
        }

        public Builder setName(String employeeName) {
            this.employeeName = employeeName;
            return this;
        }

        public Builder setDesignation(String employeeDesignation) {
            this.employeeDesignation = employeeDesignation;
            return this;
        }

        public Builder setAge(int employeeAge) {
            this.employeeAge = employeeAge;
            return this;
        }

        public Builder setExperience(int employeeExperience) {
            this.employeeExperience = employeeExperience;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}

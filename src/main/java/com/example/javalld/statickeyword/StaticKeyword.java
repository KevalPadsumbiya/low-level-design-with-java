package com.example.javalld.statickeyword;

class Employee {
    String name;
    int salary;
    static String company;

    static {
        System.out.println("Executing static block!");
        company = "Chegg";
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class StaticKeyword {

    private String nonStaticVariable = "ava";
    private static String staticVariable;

    public static void main(String[] args) {
        Employee employeeA;
        Employee employeeB = new Employee("Bhavik", 200000);
        staticMethod();
        StaticKeyword staticKeyword = new StaticKeyword();
        staticKeyword.staticVariable = "12";
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        StaticKeyword staticKeyword1 = new StaticKeyword();
        staticKeyword1.nonStaticVariable = "a";
    }

    public void another() {
        StaticInnerClass staticInnerClass = new StaticInnerClass();
    }

    public static void staticMethod() {
        System.out.println("Executing staticMethod!");
    }

    public void nonStaticMethod() {
        System.out.println("Executing nonStaticMethod!");
    }

    public static class StaticInnerClass {
        static void show() {
            System.out.println("Show method of StaticClass!");
        }
    }
}

package com.example.javalld.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThisKeyWord {
    private String name;
    private int age;

    public ThisKeyWord() {
        // call constructor using this keyword & it needs to be first line only
        this("Keval", 18);
    }

    public ThisKeyWord(String name, int age) {
        // this keyword required when there is name conflict for two variables
        this.name = name;
        this.age = age;
    }

    public String getName() {
        // this keyword not required when no conflicting name variable present
        return name;
    }

    public static void main(String[] args) {
        ThisKeyWord thisKeyWord = new ThisKeyWord();
        log.info("Name: {}", thisKeyWord.getName());
    }
}

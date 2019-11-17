package com.example.demo.entity;

/**
 * Created by mezzsy on 2019-08-13
 * Describe:
 */
public class User {
    String name;
    String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

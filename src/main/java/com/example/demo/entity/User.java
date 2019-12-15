package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by mezzsy on 2019-08-13
 * Describe:
 */
@Entity//实体类需要加此注解
public class User {
    //需要加id注解，否则会报No identifier specified for entity: com.example.demo.entity.User错误
    @Id
    int id;
    String name;

    public User() {
    }

    public User(String name, String number) {
        this.name = name;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

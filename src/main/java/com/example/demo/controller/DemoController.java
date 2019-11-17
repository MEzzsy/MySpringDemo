package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mezzsy on 2019-08-13
 * Describe:
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping(value = "/getDefaultUser", method = RequestMethod.GET)
    public User getDefaultUser() {
        return new User("mezzsy", "123");
    }

    @RequestMapping(value = "/postUser", method = RequestMethod.POST)
    public User postUser(@RequestBody User user) {
        return new User(user.getName() + "post", user.getNumber() + "post");
    }

}

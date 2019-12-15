package com.example.demo.controller;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mezzsy on 2019-12-08
 * Describe:
 */
@RestController
@RequestMapping("/datasave")
public class DataSaveController {
    //Spring Data JPA已自动注册bean，所以可自动注入
    @Autowired
    UserRepository mUserRepository;

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public List<User> findAll() {
        return mUserRepository.findAll();
    }
}

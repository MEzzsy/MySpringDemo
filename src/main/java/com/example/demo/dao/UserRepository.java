package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mezzsy on 2019-12-10
 * Describe:
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}

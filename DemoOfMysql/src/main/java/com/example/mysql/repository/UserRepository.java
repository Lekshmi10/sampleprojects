package com.example.mysql.repository;

import com.example.mysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Integer, User> {

    User findByEmail(String email);
}



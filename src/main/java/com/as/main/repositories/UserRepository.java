package com.as.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.main.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}

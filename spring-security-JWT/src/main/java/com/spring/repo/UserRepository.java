package com.spring.repo;

import com.spring.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

}

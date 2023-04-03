package com.spring;

import com.spring.entites.User;
import com.spring.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtApplication {

	@Autowired
	 UserRepository userRepository;

	@PostConstruct
	public void intUsers() {
		List<User> listOfUsers = Stream.of(
				new User(101, "varun", "1234", "varun@gmail.com"),
				new User(102, "Arpit", "4321", "Arpit@gmail.com"),
				new User(103, "Ajeet", "7890", "Ajeet@gmail.com")
		).collect(Collectors.toList());
		userRepository.saveAll(listOfUsers);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

}

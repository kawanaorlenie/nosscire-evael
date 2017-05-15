package com.example.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.controller.UserRestController;
import com.example.model.User;
import com.example.repository.UserRepository;

@SpringBootApplication(scanBasePackageClasses = { UserRestController.class, Application.class })
@EnableJpaRepositories(basePackageClasses = { UserRepository.class })
@EntityScan(basePackageClasses = { User.class })
public class Application {

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(Application.class, args);
	}

}
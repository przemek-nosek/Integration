package com.envelo.integrationapp;

import com.envelo.integrationapp.model.entities.AppUser;
import com.envelo.integrationapp.model.entities.Post;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IntegrationAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationAppApplication.class, args);
	}

}

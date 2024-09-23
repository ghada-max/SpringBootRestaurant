package com.zoch.recipe_sharing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class RecipeSharingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeSharingApplication.class, args);
	}

}

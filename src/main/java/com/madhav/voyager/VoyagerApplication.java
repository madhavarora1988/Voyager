package com.madhav.voyager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.madhav")
@EntityScan(basePackages = "com.madhav.voyager.models")
@EnableJpaRepositories(basePackages = "com.madhav.voyager.repositories")
public class VoyagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoyagerApplication.class, args);
	}

}

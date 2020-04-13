package net.javaguides.springboot.springboot_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan("net.javaguides.springboot.springboot_rest_controller")
@EnableJpaAuditing
@EntityScan("net.javaguides.springboot.springboot_rest_model")
@EnableJpaRepositories("net.javaguides.springboot.springboot_rest_repository")
@SpringBootApplication
public class SpringbootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestApplication.class, args);
		

	}

}

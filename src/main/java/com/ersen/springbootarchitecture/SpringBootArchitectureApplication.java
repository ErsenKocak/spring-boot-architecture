package com.ersen.springbootarchitecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories
@EnableWebMvc
public class SpringBootArchitectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootArchitectureApplication.class, args);
	}

}

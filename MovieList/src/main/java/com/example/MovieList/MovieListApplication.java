package com.example.MovieList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//@SpringBootApplication(scanBasePackages = {"com.example.MovieList"})
@EnableSwagger2
@ComponentScan//(basePackages = {"com.example.MovieList.service"})
@EnableAutoConfiguration

public class MovieListApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieListApplication.class, args);
	}

}

package com.example.julesbackend;

import com.example.julesbackend.model.Car;
import com.example.julesbackend.repositories.CarRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.util.stream.Stream;


@EnableResourceServer
@SpringBootApplication
public class JulesBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(JulesBackendApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CarRepository repository){
		return args -> {
			Stream.of("ferrari", "jaguar", "porsche", "lamborghini", "bugatti", "bmw").forEach(name -> {
				Car car = new Car();
				car.setName(name);
				repository.save(car);
			});
			repository.findAll().forEach(System.out::println);
		};
	}

}

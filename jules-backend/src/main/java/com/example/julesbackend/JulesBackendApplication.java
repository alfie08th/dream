package com.example.julesbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;


@SpringBootApplication
public class JulesBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(JulesBackendApplication.class, args);
	}

//	@Bean
//	ApplicationRunner init(CarRepository repository){
//		return args -> {
//			Stream.of("ferrari", "jaguar", "porsche", "lamborghini", "bugatti", "bmw").forEach(name -> {
//				Car car = new Car();
//				car.setName(name);
//				repository.save(car);
//			});
//			repository.findAll().forEach(System.out::println);
//		};
//	}

	@Bean
	public FilterRegistrationBean<CorsFilter> simpleCorsFilter(){
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
		config.setAllowedMethods(Collections.singletonList("*"));
		config.setAllowedHeaders(Collections.singletonList("*"));
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

}

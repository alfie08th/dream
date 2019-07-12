package com.example.julesbackend.controller;

import com.example.julesbackend.model.Car;
import com.example.julesbackend.repositories.CarRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class CarController {
    private CarRepository carRepository;

    public CarController(CarRepository repository){
        this.carRepository = repository;
    }
    @GetMapping("/cool")
//    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Car> coolCars(){
        return carRepository.findAll().stream()
                .filter(this::isCool)
                .collect(Collectors.toList());
    }
    private boolean isCool(Car car){
        return !car.getName().equals("Ford Pinto");
    }
}

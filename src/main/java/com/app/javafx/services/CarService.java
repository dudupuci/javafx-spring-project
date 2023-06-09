package com.app.javafx.services;

import com.app.javafx.model.entities.Car;
import com.app.javafx.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;

    public void save(Car car) {
        this.repository.save(car);
    }
}

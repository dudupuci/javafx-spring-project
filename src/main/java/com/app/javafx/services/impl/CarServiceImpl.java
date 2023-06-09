package com.app.javafx.services.impl;

import com.app.javafx.model.base.Vehicle;
import com.app.javafx.model.entities.Car;
import com.app.javafx.repositories.CarRepository;
import com.app.javafx.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository repository;

    @Override
    public void clear() {
        this.repository.deleteAll();
    }

    @Override
    public List<Car> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Car findById(UUID id) {
        return this.repository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }

    @Override
    public void save(Car car) {
        this.repository.save(car);
    }
}

package com.app.javafx.services;

import com.app.javafx.model.entities.Car;

import java.util.List;
import java.util.UUID;

public interface CarService {

    void clear();

    List<Car> findAll();

    Car findById(UUID id);

    void save(Car car);

}

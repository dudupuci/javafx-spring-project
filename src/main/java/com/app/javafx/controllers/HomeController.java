package com.app.javafx.controllers;

import com.app.javafx.model.entities.Car;
import com.app.javafx.services.CarService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomeController {

    @Autowired
    private CarService service;

    @FXML
    private TextField carNameTextField;

    @FXML
    private TextField carColorTextField;

    @FXML
    private Button createCarButton;

    @FXML
    protected void onCreateCarButtonAction() {
        var car = new Car(carNameTextField.getText(), carColorTextField.getText());
        this.service.save(car);
    }

}

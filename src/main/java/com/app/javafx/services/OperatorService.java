package com.app.javafx.services;

import com.app.javafx.model.entities.Operator;

import java.util.List;

public interface OperatorService {

    Operator findByEmailAndPassword(String email, String password);

    List<Operator> findAll();

    Boolean authenticate(Operator operator);
}

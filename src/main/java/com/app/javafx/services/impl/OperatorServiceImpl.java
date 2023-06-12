package com.app.javafx.services.impl;

import com.app.javafx.model.entities.Operator;
import com.app.javafx.repositories.OperatorRepository;
import com.app.javafx.services.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OperatorServiceImpl implements OperatorService {

    private final OperatorRepository repository;

    @Autowired
    public OperatorServiceImpl(OperatorRepository repository) {
        this.repository = Objects.requireNonNull(repository);
    }

    @Override
    public Operator findByEmailAndPassword(String email, String password) {
        return this.repository.findByEmailAndPassword(email, password);
    }

    @Override
    public List<Operator> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Boolean authenticate(Operator operator) {
        var user = this.repository.existsById(operator.getId());

        if (user) {
            return true;
        } else {
            return false;
        }
    }
}

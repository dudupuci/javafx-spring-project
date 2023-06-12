package com.app.javafx.repositories;

import com.app.javafx.model.entities.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OperatorRepository extends JpaRepository<Operator, UUID> {

    Operator findByEmailAndPassword(String email, String password);
}

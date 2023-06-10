package com.app.javafx.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Operator {

    public Operator() {
    }

    public Operator(UUID id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    @Id
    private UUID id;
    private String email;
    private String password;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

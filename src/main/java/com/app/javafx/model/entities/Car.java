package com.app.javafx.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Car {

    public Car() {}
    public Car(UUID id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Car(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Id
    private UUID id = UUID.randomUUID();
    private String name;
    private String color;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

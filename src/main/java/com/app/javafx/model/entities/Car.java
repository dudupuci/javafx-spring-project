package com.app.javafx.model.entities;

import com.app.javafx.model.base.Vehicle;
import com.app.javafx.model.enums.VehicleMark;
import com.app.javafx.model.enums.VehicleType;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Car extends Vehicle {

    public Car(UUID id, String name, VehicleType vehicleType, VehicleMark vehicleMark, BigDecimal price, Long kilometersDriven, Short horsePower) {
        super(id, name, vehicleType, vehicleMark, price, kilometersDriven, horsePower);
    }

    public Car() {
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    @Override
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public VehicleMark getVehicleMark() {
        return this.vehicleMark;
    }

    @Override
    public void setVehicleMark(VehicleMark vehicleMark) {
        this.vehicleMark = vehicleMark;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public Long getKilometersDriven() {
        return this.kilometersDriven;
    }

    @Override
    public void setKilometersDriven(Long kilometersDriven) {
        this.kilometersDriven = kilometersDriven;
    }

    @Override
    public Short getHorsePower() {
        return this.horsePower;
    }

    @Override
    public void setHorsePower(Short horsePower) {
        this.horsePower = horsePower;
    }
}

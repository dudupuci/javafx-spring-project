package com.app.javafx.model.base;

import com.app.javafx.model.enums.VehicleMark;
import com.app.javafx.model.enums.VehicleType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;
import java.util.UUID;

@MappedSuperclass
public abstract class Vehicle {

    public Vehicle(UUID id, String name, VehicleType vehicleType, VehicleMark vehicleMark, BigDecimal price, Long kilometersDriven, Short horsePower) {
        this.id = id;
        this.name = name;
        this.vehicleType = vehicleType;
        this.vehicleMark = vehicleMark;
        this.price = price;
        this.kilometersDriven = kilometersDriven;
        this.horsePower = horsePower;
    }

    public Vehicle() {
    }
    @Id
    protected UUID id;

    protected String name;

    @Enumerated(EnumType.STRING)
    protected VehicleType vehicleType;

    @Enumerated(EnumType.STRING)
    protected VehicleMark vehicleMark;

    protected BigDecimal price;

    protected Long kilometersDriven;

    protected Short horsePower;

    public abstract UUID getId();

    public abstract void setId(UUID id);
    public abstract String getName();

    public abstract void setName(String name);
    public abstract VehicleType getVehicleType();

    public abstract void setVehicleType(VehicleType vehicleType);

    public abstract VehicleMark getVehicleMark();

    public abstract void setVehicleMark(VehicleMark vehicleMark);
    public abstract BigDecimal getPrice();

    public abstract void setPrice(BigDecimal price);
    public abstract Long getKilometersDriven();

    public abstract void setKilometersDriven(Long kilometersDriven);

    public abstract Short getHorsePower();

    public abstract void setHorsePower(Short horsePower);


}

package com.gretacvdl.carapi.car_api.model;

import jakarta.persistence.*;

@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plateNumber;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPlateNumber() { return plateNumber; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }

    public Car getCar() { return car; }
    public void setCar(Car car) { this.car = car; }
}

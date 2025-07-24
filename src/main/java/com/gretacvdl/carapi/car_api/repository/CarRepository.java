package com.gretacvdl.carapi.car_api.repository;

import com.gretacvdl.carapi.car_api.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}

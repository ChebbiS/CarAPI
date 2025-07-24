package com.gretacvdl.carapi.car_api.service;

import com.gretacvdl.carapi.car_api.dto.CarDTO;

import java.util.List;

public interface CarService {
    List<CarDTO> findAll();
    CarDTO findById(Long id);
    CarDTO create(CarDTO dto);
    CarDTO update(Long id, CarDTO dto);
    void delete(Long id);
}

package com.gretacvdl.carapi.car_api.service;

import com.gretacvdl.carapi.car_api.dto.CarDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CarService {
    List<CarDTO> findAll();
    CarDTO findById(Long id);
    CarDTO create(CarDTO dto);
    CarDTO update(Long id, CarDTO dto);
    void delete(Long id);
}

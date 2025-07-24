package com.gretacvdl.carapi.car_api.controller;

import com.gretacvdl.carapi.car_api.dto.CarDTO;
import com.gretacvdl.carapi.car_api.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarDTO> getAll() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public CarDTO getOne(@PathVariable Long id) {
        return carService.findById(id);
    }

    @PostMapping
    public CarDTO create(@Valid @RequestBody CarDTO dto) {
        return carService.create(dto);
    }

    @PutMapping("/{id}")
    public CarDTO update(@PathVariable Long id, @Valid @RequestBody CarDTO dto) {
        return carService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        carService.delete(id);
    }
}

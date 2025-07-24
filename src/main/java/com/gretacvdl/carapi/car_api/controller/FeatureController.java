package com.gretacvdl.carapi.car_api.controller;

import com.gretacvdl.carapi.car_api.dto.FeatureDTO;
import com.gretacvdl.carapi.car_api.service.FeatureService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/features")
public class FeatureController {

    private final FeatureService featureService;

    @Autowired
    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @GetMapping
    public List<FeatureDTO> getAll() {
        return featureService.findAll();
    }

    @GetMapping("/{id}")
    public FeatureDTO getOne(@PathVariable Long id) {
        return featureService.findById(id);
    }

    @PostMapping
    public FeatureDTO create(@Valid @RequestBody FeatureDTO dto) {
        return featureService.create(dto);
    }

    @PutMapping("/{id}")
    public FeatureDTO update(@PathVariable Long id, @Valid @RequestBody FeatureDTO dto) {
        return featureService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        featureService.delete(id);
    }
}

package com.gretacvdl.carapi.car_api.controller;

import com.gretacvdl.carapi.car_api.dto.OwnerDTO;
import com.gretacvdl.carapi.car_api.service.OwnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<OwnerDTO> getAll() {
        return ownerService.findAll();
    }

    @GetMapping("/{id}")
    public OwnerDTO getOne(@PathVariable Long id) {
        return ownerService.findById(id);
    }

    @PostMapping
    public OwnerDTO create(@Valid @RequestBody OwnerDTO dto) {
        return ownerService.create(dto);
    }

    @PutMapping("/{id}")
    public OwnerDTO update(@PathVariable Long id, @Valid @RequestBody OwnerDTO dto) {
        return ownerService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ownerService.delete(id);
    }
}

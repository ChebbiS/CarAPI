package com.gretacvdl.carapi.car_api.controller;

import com.gretacvdl.carapi.car_api.dto.RegistrationDTO;
import com.gretacvdl.carapi.car_api.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public List<RegistrationDTO> getAll() {
        return registrationService.findAll();
    }

    @GetMapping("/{id}")
    public RegistrationDTO getOne(@PathVariable Long id) {
        return registrationService.findById(id);
    }

    @PostMapping
    public RegistrationDTO create(@Valid @RequestBody RegistrationDTO dto) {
        return registrationService.create(dto);
    }

    @PutMapping("/{id}")
    public RegistrationDTO update(@PathVariable Long id, @Valid @RequestBody RegistrationDTO dto) {
        return registrationService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        registrationService.delete(id);
    }
}

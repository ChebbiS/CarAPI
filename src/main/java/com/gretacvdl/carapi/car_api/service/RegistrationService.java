package com.gretacvdl.carapi.car_api.service;

import com.gretacvdl.carapi.car_api.dto.RegistrationDTO;

import java.util.List;

public interface RegistrationService {
    List<RegistrationDTO> findAll();
    RegistrationDTO findById(Long id);  // lève RegistrationNotFoundException si non trouvé
    RegistrationDTO create(RegistrationDTO dto);
    RegistrationDTO update(Long id, RegistrationDTO dto);
    void delete(Long id);
}

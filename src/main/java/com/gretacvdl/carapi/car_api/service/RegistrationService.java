package com.gretacvdl.carapi.car_api.service;

import com.gretacvdl.carapi.car_api.dto.RegistrationDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RegistrationService {
    List<RegistrationDTO> findAll();
    RegistrationDTO findById(Long id);  // lève RegistrationNotFoundException si non trouvé
    RegistrationDTO create(RegistrationDTO dto);
    RegistrationDTO update(Long id, RegistrationDTO dto);
    void delete(Long id);
}

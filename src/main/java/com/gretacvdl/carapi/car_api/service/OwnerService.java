package com.gretacvdl.carapi.car_api.service;

import com.gretacvdl.carapi.car_api.dto.OwnerDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OwnerService {
    List<OwnerDTO> findAll();
    OwnerDTO findById(Long id);               // OwnerNotFoundException
    OwnerDTO create(OwnerDTO dto);
    OwnerDTO update(Long id, OwnerDTO dto);
    void delete(Long id);                     // BusinessException si owner a encore des cars
}

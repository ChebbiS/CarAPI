package com.gretacvdl.carapi.car_api.service;

import com.gretacvdl.carapi.car_api.dto.OwnerDTO;

import java.util.List;

public interface OwnerService {
    List<OwnerDTO> findAll();
    OwnerDTO findById(Long id);               // OwnerNotFoundException
    OwnerDTO create(OwnerDTO dto);
    OwnerDTO update(Long id, OwnerDTO dto);
    void delete(Long id);                     // BusinessException si owner a encore des cars
}

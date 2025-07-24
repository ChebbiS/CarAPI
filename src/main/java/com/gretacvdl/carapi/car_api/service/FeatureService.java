package com.gretacvdl.carapi.car_api.service;

import com.gretacvdl.carapi.car_api.dto.FeatureDTO;

import java.util.List;

public interface FeatureService {
    List<FeatureDTO> findAll();
    FeatureDTO findById(Long id);       // lève FeatureNotFoundException si non trouvé
    FeatureDTO create(FeatureDTO dto);
    FeatureDTO update(Long id, FeatureDTO dto);
    void delete(Long id);
}

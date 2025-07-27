package com.gretacvdl.carapi.car_api.service;

import com.gretacvdl.carapi.car_api.dto.FeatureDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FeatureService {
    List<FeatureDTO> findAll();
    FeatureDTO findById(Long id);       // lève FeatureNotFoundException si non trouvé
    FeatureDTO create(FeatureDTO dto);
    FeatureDTO update(Long id, FeatureDTO dto);
    void delete(Long id);
}

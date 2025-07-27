package com.gretacvdl.carapi.car_api.service;

import com.gretacvdl.carapi.car_api.dto.FeatureDTO;
import com.gretacvdl.carapi.car_api.model.Feature;
import com.gretacvdl.carapi.car_api.repository.FeatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class FeatureServiceImpl implements FeatureService {

    private final FeatureRepository featureRepository;

    public FeatureServiceImpl(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    @Override
    public List<FeatureDTO> findAll() {
        return featureRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FeatureDTO findById(Long id) {
        Feature feature = featureRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Feature not found with id " + id));
        return toDTO(feature);
    }

    @Override
    public FeatureDTO create(FeatureDTO dto) {
        Feature feature = toEntity(dto);
        feature = featureRepository.save(feature);
        return toDTO(feature);
    }

    @Override
    public FeatureDTO update(Long id, FeatureDTO dto) {
        Feature feature = featureRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Feature not found with id " + id));

        feature.setName(dto.getName());
        feature.setDescription(dto.getDescription());

        feature = featureRepository.save(feature);
        return toDTO(feature);
    }

    @Override
    public void delete(Long id) {
        featureRepository.deleteById(id);
    }

    private FeatureDTO toDTO(Feature feature) {
        FeatureDTO dto = new FeatureDTO();
        dto.setId(feature.getId());
        dto.setName(feature.getName());
        dto.setDescription(feature.getDescription());
        return dto;
    }

    private Feature toEntity(FeatureDTO dto) {
        Feature feature = new Feature();
        feature.setName(dto.getName());
        feature.setDescription(dto.getDescription());
        return feature;
    }
}

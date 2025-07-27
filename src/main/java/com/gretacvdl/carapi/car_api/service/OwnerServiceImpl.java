package com.gretacvdl.carapi.car_api.service;

import com.gretacvdl.carapi.car_api.dto.OwnerDTO;
import com.gretacvdl.carapi.car_api.model.Owner;
import com.gretacvdl.carapi.car_api.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<OwnerDTO> findAll() {
        return ownerRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OwnerDTO findById(Long id) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        return toDTO(owner);
    }

    @Override
    public OwnerDTO create(OwnerDTO dto) {
        Owner owner = toEntity(dto);
        owner = ownerRepository.save(owner);
        return toDTO(owner);
    }

    @Override
    public OwnerDTO update(Long id, OwnerDTO dto) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        owner.setName(dto.getName());
        owner.setEmail(dto.getEmail());
        owner = ownerRepository.save(owner);
        return toDTO(owner);
    }

    @Override
    public void delete(Long id) {
        ownerRepository.deleteById(id);
    }

    private OwnerDTO toDTO(Owner owner) {
        OwnerDTO dto = new OwnerDTO();
        dto.setId(owner.getId());
        dto.setName(owner.getName());
        dto.setEmail(owner.getEmail());
        return dto;
    }

    private Owner toEntity(OwnerDTO dto) {
        Owner owner = new Owner();
        owner.setName(dto.getName());
        owner.setEmail(dto.getEmail());
        return owner;
    }
}

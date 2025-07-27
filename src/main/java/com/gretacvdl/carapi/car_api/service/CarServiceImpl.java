package com.gretacvdl.carapi.car_api.service;

import com.gretacvdl.carapi.car_api.dto.CarDTO;
import com.gretacvdl.carapi.car_api.model.Car;
import com.gretacvdl.carapi.car_api.model.Feature;
import com.gretacvdl.carapi.car_api.model.Owner;
import com.gretacvdl.carapi.car_api.model.Registration;
import com.gretacvdl.carapi.car_api.repository.CarRepository;
import com.gretacvdl.carapi.car_api.repository.FeatureRepository;
import com.gretacvdl.carapi.car_api.repository.OwnerRepository;
import com.gretacvdl.carapi.car_api.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.NoSuchElementException;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;
    private final RegistrationRepository registrationRepository;
    private final FeatureRepository featureRepository;

    public CarServiceImpl(CarRepository carRepository,
                          OwnerRepository ownerRepository,
                          RegistrationRepository registrationRepository,
                          FeatureRepository featureRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
        this.registrationRepository = registrationRepository;
        this.featureRepository = featureRepository;
    }

    @Override
    public List<CarDTO> findAll() {
        return carRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CarDTO findById(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Car not found with id " + id));
        return toDTO(car);
    }

    @Override
    public CarDTO create(CarDTO dto) {
        Car car = toEntity(dto);
        Car saved = carRepository.save(car);
        return toDTO(saved);
    }

    @Override
    public CarDTO update(Long id, CarDTO dto) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Car not found with id " + id));

        car.setModel(dto.getModel());
        car.setPrice(dto.getPrice());
        car.setYear(dto.getYear());

        if (dto.getOwnerId() != null) {
            Owner owner = ownerRepository.findById(dto.getOwnerId())
                    .orElseThrow(() -> new NoSuchElementException("Owner not found with id " + dto.getOwnerId()));
            car.setOwner(owner);
        }

        if (dto.getRegistrationId() != null) {
            Registration registration = registrationRepository.findById(dto.getRegistrationId())
                    .orElseThrow(() -> new NoSuchElementException("Registration not found with id " + dto.getRegistrationId()));
            car.setRegistration(registration);
        }

        if (dto.getFeatureIds() != null && !dto.getFeatureIds().isEmpty()) {
            Set<Feature> features = new HashSet<>(featureRepository.findAllById(dto.getFeatureIds()));
            car.setFeatures(features);
        }

        Car updated = carRepository.save(car);
        return toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    private CarDTO toDTO(Car car) {
        CarDTO dto = new CarDTO();
        dto.setId(car.getId());
        dto.setModel(car.getModel());
        dto.setPrice(car.getPrice());
        dto.setYear(car.getYear());

        if (car.getOwner() != null)
            dto.setOwnerId(car.getOwner().getId());

        if (car.getRegistration() != null)
            dto.setRegistrationId(car.getRegistration().getId());

        if (car.getFeatures() != null)
            dto.setFeatureIds(car.getFeatures().stream()
                    .map(Feature::getId)
                    .collect(Collectors.toSet()));

        return dto;
    }

    private Car toEntity(CarDTO dto) {
        Car car = new Car();
        car.setModel(dto.getModel());
        car.setPrice(dto.getPrice());
        car.setYear(dto.getYear());

        if (dto.getOwnerId() != null) {
            Owner owner = ownerRepository.findById(dto.getOwnerId())
                    .orElseThrow(() -> new NoSuchElementException("Owner not found with id " + dto.getOwnerId()));
            car.setOwner(owner);
        }

        if (dto.getRegistrationId() != null) {
            Registration registration = registrationRepository.findById(dto.getRegistrationId())
                    .orElseThrow(() -> new NoSuchElementException("Registration not found with id " + dto.getRegistrationId()));
            car.setRegistration(registration);
        }

        if (dto.getFeatureIds() != null && !dto.getFeatureIds().isEmpty()) {
            Set<Feature> features = new HashSet<>(featureRepository.findAllById(dto.getFeatureIds()));
            car.setFeatures(features);
        }

        return car;
    }
}

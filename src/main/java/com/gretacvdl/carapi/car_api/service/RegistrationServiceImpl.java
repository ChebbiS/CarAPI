package com.gretacvdl.carapi.car_api.service;

import com.gretacvdl.carapi.car_api.dto.RegistrationDTO;
import com.gretacvdl.carapi.car_api.model.Car;
import com.gretacvdl.carapi.car_api.model.Registration;
import com.gretacvdl.carapi.car_api.repository.CarRepository;
import com.gretacvdl.carapi.car_api.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final CarRepository carRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository, CarRepository carRepository) {
        this.registrationRepository = registrationRepository;
        this.carRepository = carRepository;
    }

    @Override
    public List<RegistrationDTO> findAll() {
        return registrationRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RegistrationDTO findById(Long id) {
        Registration registration = registrationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Registration not found with id " + id));
        return toDTO(registration);
    }

    @Override
    public RegistrationDTO create(RegistrationDTO dto) {
        Registration registration = toEntity(dto);
        Registration saved = registrationRepository.save(registration);
        return toDTO(saved);
    }

    @Override
    public RegistrationDTO update(Long id, RegistrationDTO dto) {
        Registration registration = registrationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Registration not found with id " + id));

        registration.setPlateNumber(dto.getPlateNumber());

        try {
            registration.setExpiryDate(LocalDate.parse(dto.getExpiryDate()));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid expiry date format. Use YYYY-MM-DD.");
        }

        // Optionally update the car if carId is set
        if (dto.getCarId() != null) {
            Car car = carRepository.findById(dto.getCarId())
                    .orElseThrow(() -> new NoSuchElementException("Car not found with id " + dto.getCarId()));
            registration.setCar(car);
        }

        Registration updated = registrationRepository.save(registration);
        return toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        registrationRepository.deleteById(id);
    }

    private RegistrationDTO toDTO(Registration registration) {
        RegistrationDTO dto = new RegistrationDTO();
        dto.setId(registration.getId());
        dto.setPlateNumber(registration.getPlateNumber());
        dto.setExpiryDate(registration.getExpiryDate() != null ? registration.getExpiryDate().toString() : null);
        dto.setCarId(registration.getCar() != null ? registration.getCar().getId() : null);
        return dto;
    }

    private Registration toEntity(RegistrationDTO dto) {
        Registration registration = new Registration();
        registration.setPlateNumber(dto.getPlateNumber());

        try {
            registration.setExpiryDate(LocalDate.parse(dto.getExpiryDate()));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid expiry date format. Use YYYY-MM-DD.");
        }

        if (dto.getCarId() != null) {
            Car car = carRepository.findById(dto.getCarId())
                    .orElseThrow(() -> new NoSuchElementException("Car not found with id " + dto.getCarId()));
            registration.setCar(car);
        }
        return registration;
    }
}

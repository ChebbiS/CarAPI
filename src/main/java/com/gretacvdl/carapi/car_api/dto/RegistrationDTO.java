package com.gretacvdl.carapi.car_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class RegistrationDTO {
    private Long id;
    @NotBlank(message = "Le numéro de plaque est obligatoire")
    private String plateNumber;
    @NotBlank(message = "La date d'expiration est obligatoire")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "La date doit être au format YYYY-MM-DD")
    private String expiryDate;
    private Long carId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }
}

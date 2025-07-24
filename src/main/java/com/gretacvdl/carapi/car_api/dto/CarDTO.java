package com.gretacvdl.carapi.car_api.dto;

import jakarta.validation.constraints.*;

import java.util.Set;

public class CarDTO {
    private Long id;
    @NotNull(message = "Le prix est requis")
    @Positive(message = "Le prix doit être supérieur à zéro")
    private Double price;
    @NotBlank(message = "Le modèle est obligatoire")
    private String model;
    @NotNull(message = "L'année est requise")
    @Min(value = 1886, message = "L'année doit être supérieure ou égale à 1886")
    @Max(value = 2100, message = "L'année doit être inférieure ou égale à 2100")
    private Integer year;
    private Long ownerId;
    private Long registrationId;
    @NotEmpty(message = "La liste des options ne doit pas être vide")
    @Size(min = 1, message = "Au moins une option doit être spécifiée")
    private Set<Long> featureIds;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }

    public Long getRegistrationId() { return registrationId; }
    public void setRegistrationId(Long registrationId) { this.registrationId = registrationId; }

    public Set<Long> getFeatureIds() { return featureIds; }
    public void setFeatureIds(Set<Long> featureIds) { this.featureIds = featureIds; }
}

package com.gretacvdl.carapi.car_api.exception;

public class RegistrationNotFoundException extends RuntimeException {
    public RegistrationNotFoundException(Long id) {
        super("Registration not found with id: " + id);
    }
}

package com.gretacvdl.carapi.car_api.exception;

public class FeatureNotFoundException extends RuntimeException {
    public FeatureNotFoundException(Long id) {
        super("Feature not found with id: " + id);
    }
}

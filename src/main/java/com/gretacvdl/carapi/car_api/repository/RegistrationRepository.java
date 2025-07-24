package com.gretacvdl.carapi.car_api.repository;

import com.gretacvdl.carapi.car_api.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}

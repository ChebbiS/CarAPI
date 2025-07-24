package com.gretacvdl.carapi.car_api.repository;

import com.gretacvdl.carapi.car_api.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}

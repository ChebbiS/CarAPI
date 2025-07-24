package com.gretacvdl.carapi.car_api.repository;

import com.gretacvdl.carapi.car_api.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
}

package com.belediye.bproject.repository;

import com.belediye.bproject.models.MunicipalityService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MunicipalityServiceRepository extends JpaRepository<MunicipalityService, Long> {
}

package com.belediye.bproject.repository;

import com.belediye.bproject.models.TaxPayer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaxPayerRepository extends JpaRepository<TaxPayer, Long> {
    TaxPayer findByNationalIdNo(Long nationalIdNo); // findByNationalId yerine findByNationalIdNo
}
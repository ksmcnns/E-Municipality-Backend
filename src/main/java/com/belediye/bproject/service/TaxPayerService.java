package com.belediye.bproject.service;

import com.belediye.bproject.dto.RegisterTaxPayerDTO;
import com.belediye.bproject.models.TaxPayer;
import org.springframework.stereotype.Service;

@Service
public interface TaxPayerService {
     void registerTaxPayer(RegisterTaxPayerDTO registerTaxPayerDTO);
     boolean isTaxPayerRegistered(Long nationalId);
}

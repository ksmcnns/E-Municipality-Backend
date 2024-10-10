package com.belediye.bproject.service.impl;

import com.belediye.bproject.dto.RegisterTaxPayerDTO;
import com.belediye.bproject.models.Residance;
import com.belediye.bproject.models.TaxPayer;
import com.belediye.bproject.repository.ResidanceRepository;
import com.belediye.bproject.repository.TaxPayerRepository;
import com.belediye.bproject.service.TaxPayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TaxPayerServiceImpl implements TaxPayerService {

    private final ResidanceRepository residanceRepository;
    private final TaxPayerRepository taxPayerRepository;

    @Autowired
    public TaxPayerServiceImpl(ResidanceRepository residanceRepository, TaxPayerRepository taxPayerRepository) {
        this.residanceRepository = residanceRepository;
        this.taxPayerRepository = taxPayerRepository;
    }
    @Override
    @Transactional
    public void registerTaxPayer(RegisterTaxPayerDTO registerTaxPayerDTO) {
        // Residence kaydı oluştur ve kaydet
        Residance residance = new Residance();
        residance.setNationalIdNo(registerTaxPayerDTO.getNationalIdNo());
        residance.setCity(registerTaxPayerDTO.getCity());
        residance.setDistrict(registerTaxPayerDTO.getDistrict());
        residance.setPostCode(registerTaxPayerDTO.getPostcode());
        residance.setAddress(registerTaxPayerDTO.getAddress());
        // Residence tablosuna kaydet
        Residance savedResidance = residanceRepository.save(residance);
        // TaxPayer kaydı oluştur ve kaydet
        TaxPayer taxPayer = new TaxPayer();
        taxPayer.setNationalIdNo(registerTaxPayerDTO.getNationalIdNo());
        taxPayer.setName(registerTaxPayerDTO.getName());
        taxPayer.setSurname(registerTaxPayerDTO.getSurname());
        taxPayer.setEmail(registerTaxPayerDTO.getEmail());
        taxPayer.setPassword(registerTaxPayerDTO.getPassword());
        taxPayer.setBirthDate(registerTaxPayerDTO.getBirthDate());
        taxPayer.setTelephone(registerTaxPayerDTO.getTelephone());
        taxPayer.setGender(registerTaxPayerDTO.getGender());
        taxPayer.setMunicipalityId(registerTaxPayerDTO.getMunicipalityId());
        taxPayerRepository.save(taxPayer);
    }
    @Override
    public boolean isTaxPayerRegistered(Long nationalIdNo) {
        TaxPayer taxPayer = taxPayerRepository.findByNationalIdNo(nationalIdNo);
        if(taxPayer.getNationalIdNo() == nationalIdNo)
        return true;
        else
            return false;
    }
}

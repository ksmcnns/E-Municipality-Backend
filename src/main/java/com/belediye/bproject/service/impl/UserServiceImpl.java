package com.belediye.bproject.service.impl;

import com.belediye.bproject.dto.UserAuthenticationDTO;
import com.belediye.bproject.models.TaxPayer;
import com.belediye.bproject.repository.TaxPayerRepository;
import com.belediye.bproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TaxPayerRepository taxPayerRepository;

    @Override
    public List<TaxPayer> getAllTaxPayer(Long nationalIdNo) {
        return List.of();
    }
    public boolean authenticateUser(Long nationalIdNo, String password){
        TaxPayer taxPayer = taxPayerRepository.findByNationalIdNo(nationalIdNo);
        if (taxPayer.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
    @Override
    public TaxPayer saveTaxPayer(TaxPayer taxPayer) {
        return taxPayerRepository.save(taxPayer);
    }
    @Override
    public UserAuthenticationDTO getUserDetails(Long nationalIdNo) {
        TaxPayer taxPayer =  taxPayerRepository.findByNationalIdNo(nationalIdNo);
        return new UserAuthenticationDTO(taxPayer.getNationalIdNo(),taxPayer.getName(),taxPayer.getSurname(),taxPayer.getPassword());

    }

}

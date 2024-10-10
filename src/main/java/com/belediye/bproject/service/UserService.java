package com.belediye.bproject.service;

import com.belediye.bproject.dto.UserAuthenticationDTO;
import com.belediye.bproject.models.TaxPayer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    List<TaxPayer> getAllTaxPayer(Long nationalIdNo);
    boolean authenticateUser(Long nationalIdNo, String password);
    TaxPayer saveTaxPayer(TaxPayer taxPayer);
    UserAuthenticationDTO getUserDetails(Long nationalIdNo);
}

package com.belediye.bproject.service;

import com.belediye.bproject.dto.DebitInfoDTO;
import com.belediye.bproject.models.Debit;

import java.util.List;

public interface DebitService {
    List<Debit> getAllDebitsByTaxpayer(Long nationalIdNo);
    List<Debit> getDebitsWithServiceNamesByNationalIdNo(Long nationalIdNo);
    List<DebitInfoDTO> findDebitInfoByNationalId(Long nationalIdNo);
}

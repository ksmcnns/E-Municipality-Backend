package com.belediye.bproject.service.impl;

import com.belediye.bproject.dto.DebitInfoDTO;
import com.belediye.bproject.models.Debit;
import com.belediye.bproject.repository.DebitRepository;
import com.belediye.bproject.service.DebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DebitServiceImpl implements DebitService {
    @Autowired
    private DebitRepository debitRepository;
    @Override
    public List<Debit> getAllDebitsByTaxpayer(Long nationalIdNo) {
        List<Debit> debits = debitRepository.findByNationalId(nationalIdNo);
        return debits;
    }
    public List<Debit> getDebitsWithServiceNamesByNationalIdNo(Long nationalIdNo) {
        return debitRepository.findDebitsWithServiceNamesByNationalIdNo(nationalIdNo);
    }

    @Override
    public List<DebitInfoDTO> findDebitInfoByNationalId(Long nationalIdNo) {
        return debitRepository.findDebitInfoByNationalId(nationalIdNo);
    }
}

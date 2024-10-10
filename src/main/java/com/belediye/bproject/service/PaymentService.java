package com.belediye.bproject.service;

import com.belediye.bproject.dto.DebitPaymentDTO;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    void payDebit(DebitPaymentDTO debitPaymentDTO);
    boolean checkPayment(DebitPaymentDTO debitPaymentDTO);
}

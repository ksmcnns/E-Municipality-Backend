package com.belediye.bproject.service.impl;

import com.belediye.bproject.dto.DebitPaymentDTO;
import com.belediye.bproject.models.Debit;
import com.belediye.bproject.models.PaymentDetails;
import com.belediye.bproject.repository.DebitRepository;
import com.belediye.bproject.repository.PaymentRepository;
import com.belediye.bproject.service.PaymentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final DebitRepository debitRepository;
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(DebitRepository debitRepository, PaymentRepository paymentRepository) {
        this.debitRepository = debitRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void payDebit(DebitPaymentDTO debitPaymentDTO) {

        Debit debit = debitRepository.findByNationalIdAndId(debitPaymentDTO.getNationalId(), debitPaymentDTO.getId());
        if (debit != null) {
            debit.setDebitStatus(true);
            debitRepository.save(debit);

        } else {
            throw new RuntimeException("Debit not found with given National ID and Debit ID.");
        }
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setDebitId(debitPaymentDTO.getId());
        paymentDetails.setPaymentDate(LocalDateTime.now());
        paymentDetails.setCardNumber(debitPaymentDTO.getCardNumber());
        paymentDetails.setCardOwner(debitPaymentDTO.getCardOwner());
        paymentDetails.setPaymentAmount(debitPaymentDTO.getPaymentAmount());
        paymentDetails.setCvvNumber(debitPaymentDTO.getCvvNumber());
        paymentRepository.save(paymentDetails);
    }

    @Override
    public boolean checkPayment(DebitPaymentDTO debitPaymentDTO) {
        Debit debit = debitRepository.findByNationalIdAndId(debitPaymentDTO.getNationalId(), debitPaymentDTO.getId());
        return debit != null && debit.isDebitStatus();
    }
}

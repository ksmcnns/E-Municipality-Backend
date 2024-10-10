package com.belediye.bproject.controller;

import com.belediye.bproject.dto.ApiResponse;
import com.belediye.bproject.dto.DebitPaymentDTO;
import com.belediye.bproject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<ApiResponse<DebitPaymentDTO>> payDebit(@RequestBody DebitPaymentDTO debitPaymentDTO) {
        if (debitPaymentDTO == null) {
            ApiResponse<DebitPaymentDTO> apiResponse = new ApiResponse<>();
            return ResponseEntity.badRequest().body(apiResponse);
        }
        paymentService.payDebit(debitPaymentDTO);
        boolean isSuccessfullyPaid = paymentService.checkPayment(debitPaymentDTO);
        if (isSuccessfullyPaid) {
            ApiResponse<DebitPaymentDTO> apiResponse = new ApiResponse<>(debitPaymentDTO);
            return ResponseEntity.ok(apiResponse);
        } else {
            DebitPaymentDTO nonPaid = debitPaymentDTO;
            nonPaid.setPaymentStatus(false);
            ApiResponse<DebitPaymentDTO> apiResponse = new ApiResponse<>(nonPaid);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
        }
    }
}


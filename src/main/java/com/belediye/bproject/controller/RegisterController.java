package com.belediye.bproject.controller;

import com.belediye.bproject.dto.ApiResponse;
import com.belediye.bproject.dto.RegisterTaxPayerDTO;
import com.belediye.bproject.service.TaxPayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/taxpayers")
public class RegisterController {
    private final TaxPayerService taxPayerService;

    @Autowired
    public RegisterController(TaxPayerService taxPayerService) {
        this.taxPayerService = taxPayerService;
    }
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> registerTaxPayer(@RequestBody RegisterTaxPayerDTO registerTaxPayerDTO) {
        taxPayerService.registerTaxPayer(registerTaxPayerDTO);
        boolean isRegistered = taxPayerService.isTaxPayerRegistered(registerTaxPayerDTO.getNationalIdNo());
        if (isRegistered) {
            return ResponseEntity.ok(new ApiResponse<>("İşlem Başarılı")); // İstediğiniz yanıtı dönebilirsiniz
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ApiResponse<>("İşlem Başarısız"));
        }
    }
}

package com.belediye.bproject.controller;

import com.belediye.bproject.dto.DebitInfoDTO;
import com.belediye.bproject.models.Debit;
import com.belediye.bproject.service.DebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/taxpayer")
public class DebitController {
    @Autowired
    DebitService debitService;

    @GetMapping("debit/{nationalIdNo}")
    public List<DebitInfoDTO> getDebtsOfTaxpayer(@PathVariable Long nationalIdNo){
        return debitService.findDebitInfoByNationalId(nationalIdNo);
    }
}

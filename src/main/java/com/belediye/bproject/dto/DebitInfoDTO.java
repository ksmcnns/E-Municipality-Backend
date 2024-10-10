package com.belediye.bproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DebitInfoDTO {

    private Long id;
    private Long nationalIdNo;
    private double debitAmount;
    private int debitType;
    private LocalDateTime paymentDeadline;
    private boolean debitStatus;
    private String name;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNationalIdNo() {
        return nationalIdNo;
    }

    public void setNationalIdNo(Long nationalIdNo) {
        this.nationalIdNo = nationalIdNo;
    }

    public double getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(double debitAmount) {
        this.debitAmount = debitAmount;
    }

    public int getDebitType() {
        return debitType;
    }

    public void setDebitType(int debitType) {
        this.debitType = debitType;
    }

    public LocalDateTime getPaymentDeadline() {
        return paymentDeadline;
    }

    public void setPaymentDeadline(LocalDateTime paymentDeadline) {
        this.paymentDeadline = paymentDeadline;
    }

    public boolean isDebitStatus() {
        return debitStatus;
    }

    public void setDebitStatus(boolean debitStatus) {
        this.debitStatus = debitStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

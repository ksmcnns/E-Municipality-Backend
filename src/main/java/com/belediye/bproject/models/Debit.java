package com.belediye.bproject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="debit")
public class Debit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "national_id_no")
    private Long nationalId;
    @Column(name = "debit_type")
    private int debitType;
    @ManyToOne
    @JoinColumn(name = "debit_type", referencedColumnName = "id", insertable = false, updatable = false)
    private MunicipalityService municipalityService;
    @Column(name = "debit_status")
    private boolean debitStatus;
    @Column(name = "debit_amount")
    private double debitAmount;
    @Column(name = "payment_deadline")
    private LocalDateTime paymentDeadline;


     public MunicipalityService getMunicipalityService() {
        return municipalityService;
    }

    public void setMunicipalityService(MunicipalityService municipalityService) {
        this.municipalityService = municipalityService;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNationalId() {
        return nationalId;
    }

    public void setNationalId(Long nationalId) {
        this.nationalId = nationalId;
    }

    public int getDebitType() {
        return debitType;
    }

    public void setDebitType(int debitType) {
        this.debitType = debitType;
    }

    public boolean isDebitStatus() {
        return debitStatus;
    }

    public void setDebitStatus(boolean debitStatus) {
        this.debitStatus = debitStatus;
    }

    public double getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(double debitAmount) {
        this.debitAmount = debitAmount;
    }

    public LocalDateTime getPaymentDeadline() {
        return paymentDeadline;
    }

    public void setPaymentDeadline(LocalDateTime paymentDeadline) {
        this.paymentDeadline = paymentDeadline;
    }
}

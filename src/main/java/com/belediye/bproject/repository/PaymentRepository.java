package com.belediye.bproject.repository;

import com.belediye.bproject.models.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentDetails,Long> {
}

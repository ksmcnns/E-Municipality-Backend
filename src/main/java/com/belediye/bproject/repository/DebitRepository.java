package com.belediye.bproject.repository;

import com.belediye.bproject.dto.DebitInfoDTO;
import com.belediye.bproject.dto.DebitPaymentDTO;
import com.belediye.bproject.models.Debit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebitRepository extends JpaRepository<Debit, Long> {
    List<Debit> findByNationalId(Long nationalIdNo);

    @Query("SELECT d FROM Debit d JOIN d.municipalityService ms WHERE d.nationalId = :nationalIdNo")
    List<Debit> findDebitsWithServiceNamesByNationalIdNo(@Param("nationalIdNo") Long nationalIdNo);

    @Query("SELECT new com.belediye.bproject.dto.DebitInfoDTO(" +
            "d.id, d.nationalId, d.debitAmount, d.debitType, " +
            "d.paymentDeadline, d.debitStatus, " +
            "ms.name) " +
            "FROM Debit d " +
            "JOIN MunicipalityService ms ON d.debitType = ms.id " +
            "WHERE d.nationalId = :nationalIdNo")
    List<DebitInfoDTO> findDebitInfoByNationalId(@Param("nationalIdNo") Long nationalIdNo);

    @Query(value = "SELECT * FROM debit d WHERE d.national_id_no = :nationalId AND d.id = :id", nativeQuery = true)
    Debit findByNationalIdAndId(@Param("nationalId") Long nationalId, @Param("id") Long id);


}

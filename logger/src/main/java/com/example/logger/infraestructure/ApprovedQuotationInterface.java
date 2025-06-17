package com.example.logger.infraestructure;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.logger.infraestructure.Models.ApprovedQuotation;

@Repository
public interface ApprovedQuotationInterface extends JpaRepository<ApprovedQuotation, UUID> {
     List<ApprovedQuotation> findByCreatedAtBetween(Instant startDate, Instant endDate);
}

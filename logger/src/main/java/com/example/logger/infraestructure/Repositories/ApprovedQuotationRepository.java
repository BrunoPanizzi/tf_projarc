package com.example.logger.infraestructure.Repositories;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.logger.infraestructure.Models.ApprovedQuotation;
import com.example.logger.infraestructure.Repositories.mappers.ApprovedQuotationMapper;
import com.example.logger.domain.entities.ApprovedQuotationEntity;
import com.example.logger.infraestructure.ApprovedQuotationInterface;

@Repository
public class ApprovedQuotationRepository {
    private final ApprovedQuotationInterface approvedQuotationInterface;
    private final ApprovedQuotationMapper approvedQuotationMapper;

    public ApprovedQuotationRepository(ApprovedQuotationInterface approvedQuotationInterface,
            ApprovedQuotationMapper approvedQuotationMapper) {
        this.approvedQuotationInterface = approvedQuotationInterface;
        this.approvedQuotationMapper = approvedQuotationMapper;
    }

    public ApprovedQuotationEntity create(Instant approvedAt, Double taxAmount, Double totalAmount) {
        ApprovedQuotation approvedQuotation = new ApprovedQuotation(approvedAt, taxAmount, totalAmount);
        approvedQuotationInterface.save(approvedQuotation);
        return approvedQuotationMapper.toEntity(approvedQuotation);
    }

    public List<ApprovedQuotationEntity> listByMonthAndYear(int month, int year) {
        LocalDate startLocalDate = LocalDate.of(year, month, 1);
        LocalDate endLocalDate = startLocalDate.plusMonths(1);

        Instant startInstant = startLocalDate.atStartOfDay().toInstant(java.time.ZoneOffset.UTC);
        Instant endInstant = endLocalDate.atStartOfDay().toInstant(java.time.ZoneOffset.UTC);
        List<ApprovedQuotation> approvedQuotations = approvedQuotationInterface
                .findByApprovedAtBetween(startInstant, endInstant);

        return approvedQuotations.stream()
                .map(approvedQuotationMapper::toEntity)
                .collect(Collectors.toList());
    }

}

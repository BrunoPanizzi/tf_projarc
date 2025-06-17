package com.example.logger.infraestructure.Repositories;

import java.time.Instant;

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

}

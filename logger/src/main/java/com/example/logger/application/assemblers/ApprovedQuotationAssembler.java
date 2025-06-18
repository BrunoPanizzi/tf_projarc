package com.example.logger.application.assemblers;

import org.springframework.stereotype.Component;

import com.example.logger.domain.entities.ApprovedQuotationEntity;
import com.example.logger.dtos.ApprovedQuotationDto;

@Component
public class ApprovedQuotationAssembler {

    public ApprovedQuotationDto toDto(
        ApprovedQuotationEntity approvedQuotation
    ) {
        return new ApprovedQuotationDto(
            approvedQuotation.getId(),
            approvedQuotation.getApprovedAt().toString(),
            approvedQuotation.getTaxAmount(),
            approvedQuotation.getTotalPrice()
        );
    }
    
}

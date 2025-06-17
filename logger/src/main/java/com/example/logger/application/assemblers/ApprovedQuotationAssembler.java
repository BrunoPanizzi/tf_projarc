package com.example.logger.application.assemblers;

import com.example.logger.domain.entities.ApprovedQuotationEntity;
import com.example.logger.dtos.ApprovedQuotationDto;

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

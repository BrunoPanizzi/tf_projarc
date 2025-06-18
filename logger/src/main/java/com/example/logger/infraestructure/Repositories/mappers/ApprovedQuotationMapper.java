package com.example.logger.infraestructure.Repositories.mappers;

import org.springframework.stereotype.Component;

import com.example.logger.domain.entities.ApprovedQuotationEntity;
import com.example.logger.infraestructure.Models.ApprovedQuotation;

@Component
public class ApprovedQuotationMapper {

    public ApprovedQuotationEntity toEntity(
        ApprovedQuotation model
    ) {
        return new ApprovedQuotationEntity(
            model.getId(),
            model.getApprovedAt(),
            model.getTaxAmount(),
            model.getTotalAmount()
        );
    }
    
}

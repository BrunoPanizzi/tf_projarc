package com.example.logger.application.usecases;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.example.logger.application.assemblers.ApprovedQuotationAssembler;
import com.example.logger.domain.entities.ApprovedQuotationEntity;
import com.example.logger.dtos.ApprovedQuotationDto;
import com.example.logger.dtos.CreateApprovedQuotationDto;
import com.example.logger.infraestructure.Repositories.ApprovedQuotationRepository;

@Service
public class CreateApprovedQuotationUsecase {

    private ApprovedQuotationRepository approvedQuotationRepository;
    private ApprovedQuotationAssembler approvedQuotationAssembler;

    public CreateApprovedQuotationUsecase(ApprovedQuotationRepository approvedQuotationRepository,
            ApprovedQuotationAssembler approvedQuotationAssembler) {
        this.approvedQuotationRepository = approvedQuotationRepository;
        this.approvedQuotationAssembler = approvedQuotationAssembler;
    }

    public ApprovedQuotationDto create(CreateApprovedQuotationDto createApprovedQuotationDto) {
        ApprovedQuotationEntity approvedQuotationEntity = approvedQuotationRepository.create(
                Instant.parse(createApprovedQuotationDto.approvedAtIso()),
                createApprovedQuotationDto.taxAmount(),
                createApprovedQuotationDto.totalPrice());

        return approvedQuotationAssembler.toDto(approvedQuotationEntity);
    }

}

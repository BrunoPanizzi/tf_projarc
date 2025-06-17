package com.example.logger.controllers;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.logger.application.usecases.CreateApprovedQuotationUsecase;
import com.example.logger.dtos.ApprovedQuotationDto;
import com.example.logger.dtos.CreateApprovedQuotationDto;

@RestController
@RequestMapping("/approved-quotation")
public class ApprovedQuotationController {

    private final CreateApprovedQuotationUsecase createApprovedQuotationUsecase;

    public ApprovedQuotationController(CreateApprovedQuotationUsecase createApprovedQuotationUsecase) {
        this.createApprovedQuotationUsecase = createApprovedQuotationUsecase;
    }
    

    @PostMapping
    public ApprovedQuotationDto create(CreateApprovedQuotationDto createApprovedQuotationDto) {
        return createApprovedQuotationUsecase.create(createApprovedQuotationDto);
    }
}
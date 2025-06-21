package com.example.logger.controllers;

import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.logger.application.usecases.CreateApprovedQuotationUsecase;
import com.example.logger.application.usecases.GetTotalProfitUsecase;
import com.example.logger.dtos.ApprovedQuotationDto;
import com.example.logger.dtos.CreateApprovedQuotationDto;
import com.example.logger.dtos.GetTotalProfitDtoResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/approved-quotation")
public class ApprovedQuotationController {

    private final CreateApprovedQuotationUsecase createApprovedQuotationUsecase;
    private final GetTotalProfitUsecase getTotalProfitUsecase;

    public ApprovedQuotationController(CreateApprovedQuotationUsecase createApprovedQuotationUsecase,
            GetTotalProfitUsecase getTotalProfitUsecase) {
        this.createApprovedQuotationUsecase = createApprovedQuotationUsecase;
        this.getTotalProfitUsecase = getTotalProfitUsecase;
    }

    @PostMapping
    public ApprovedQuotationDto create(@Valid @RequestBody CreateApprovedQuotationDto createApprovedQuotationDto) {
        return createApprovedQuotationUsecase.create(createApprovedQuotationDto);
    }

    @GetMapping("/total-profit")
    public GetTotalProfitDtoResponse getTotalProfit(@Valid @RequestParam(name = "month") Integer monthNumber,
            @Valid @RequestParam(name = "year") Integer yearNumber) throws BadRequestException {
        System.out.println("Received request for total profit with month: " + monthNumber + " and year: " + yearNumber);
        return getTotalProfitUsecase.listTotalProfit(
                monthNumber,
                yearNumber);
    }
}
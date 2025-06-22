package com.example.logger.controllers;

import com.example.logger.application.usecases.CreateApprovedQuotationUsecase;
import com.example.logger.dtos.CreateApprovedQuotationDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ApprovedQuotationListener {
    private final CreateApprovedQuotationUsecase createApprovedQuotationUsecase;

    public ApprovedQuotationListener(CreateApprovedQuotationUsecase createApprovedQuotationUsecase) {
        this.createApprovedQuotationUsecase = createApprovedQuotationUsecase;
    }

    @RabbitListener(queues = "approved-quotation-queue")
    public void receiveMessage(CreateApprovedQuotationDto dto) {
        createApprovedQuotationUsecase.create(dto);
    }
}
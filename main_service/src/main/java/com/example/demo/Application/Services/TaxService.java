package com.example.demo.Application.Services;

import org.springframework.stereotype.Component;

import com.example.demo.Domain.Entities.QuotationEntity;

@Component
public class TaxService {
    TaxService() {

    }

    public QuotationPriceInfo calculateTax(QuotationEntity quotationDto) {
        // TODO: call the other service
        return new QuotationPriceInfo();
    }
}

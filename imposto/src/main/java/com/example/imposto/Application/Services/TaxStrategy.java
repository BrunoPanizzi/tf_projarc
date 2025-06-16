package com.example.imposto.Application.Services;

import com.example.imposto.presentation.dtos.TaxCalculationDto;
import com.example.imposto.presentation.dtos.TaxCalculationResultDto;

public abstract class TaxStrategy {
    public abstract TaxCalculationResultDto calculateTax(TaxCalculationDto taxCalculationDto);

    protected double calculateTotalPrice(TaxCalculationDto taxCalculationDto) {
        return taxCalculationDto.getProducts().stream()
                .mapToDouble(product -> product.getPrice() * product.getAmount())
                .sum();
    }
}
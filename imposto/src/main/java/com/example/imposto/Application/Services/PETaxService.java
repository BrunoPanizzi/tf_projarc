package com.example.imposto.Application.Services;

import org.springframework.stereotype.Service;

import com.example.imposto.presentation.dtos.TaxCalculationDto;
import com.example.imposto.presentation.dtos.TaxCalculationResultDto;
import com.example.imposto.presentation.dtos.enums.State;

@Service
public class PETaxService extends TaxStrategy {
    private static final double REGULAR_TAX = 0.15;
    private static final double ESSENTIAL_TAX = 0.05;

    @Override
    public TaxCalculationResultDto calculateTax(TaxCalculationDto taxCalculationDto) {
        double totalTax = 0.0;
        double originalPrice = this.calculateTotalPrice(taxCalculationDto);

        for (var product : taxCalculationDto.getProducts()) {
            String description = product.getDescription();
            double price = product.getPrice();
            int amount = product.getAmount();

            boolean isEssential = description != null && description.trim().endsWith("*");
            double taxRate = isEssential ? ESSENTIAL_TAX : REGULAR_TAX;

            totalTax += price * amount * taxRate;
        }

        return TaxCalculationResultDto.builder()
                .tax(totalTax)
                .originalPrice(originalPrice)
                .finalPrice(originalPrice + totalTax)
                .state(State.PERNAMBUCO)
                .build();
    }
}

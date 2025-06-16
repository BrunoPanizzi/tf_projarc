package com.example.imposto.Application.Services;

import org.springframework.stereotype.Service;

import com.example.imposto.presentation.dtos.TaxCalculationDto;
import com.example.imposto.presentation.dtos.TaxCalculationResultDto;
import com.example.imposto.presentation.dtos.enums.State;

@Service
public class SPTaxService extends TaxStrategy {
    private static final double TAX = 0.12;

    @Override
    public TaxCalculationResultDto calculateTax(TaxCalculationDto taxCalculationDto) {
        double totalPrice = this.calculateTotalPrice(taxCalculationDto);
        double tax = totalPrice * TAX;

        return TaxCalculationResultDto.builder()
                .tax(tax)
                .originalPrice(totalPrice)
                .finalPrice(totalPrice + tax)
                .state(State.SP)
                .build();
    }
}

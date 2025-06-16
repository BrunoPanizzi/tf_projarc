package com.example.imposto.Application.Services;

import org.springframework.stereotype.Service;

import com.example.imposto.presentation.dtos.TaxCalculationDto;
import com.example.imposto.presentation.dtos.TaxCalculationResultDto;
import com.example.imposto.presentation.dtos.enums.State;

@Service
public class RSTaxService extends TaxStrategy {
    private static final double TAX = 0.10;

    @Override
    public TaxCalculationResultDto calculateTax(TaxCalculationDto taxCalculationDto) {
        double totalPrice = this.calculateTotalPrice(taxCalculationDto);
        double tax = 0.0;

        if (totalPrice >= 100.0) {
            tax = totalPrice * TAX;
        }

        return TaxCalculationResultDto.builder()
                .tax(tax)
                .originalPrice(totalPrice)
                .finalPrice(totalPrice + tax)
                .state(State.RS)
                .build();
    }

}

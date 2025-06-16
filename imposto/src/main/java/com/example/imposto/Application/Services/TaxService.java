package com.example.imposto.Application.Services;

import org.springframework.stereotype.Service;

import com.example.imposto.presentation.dtos.TaxCalculationDto;
import com.example.imposto.presentation.dtos.TaxCalculationResultDto;
import com.example.imposto.presentation.dtos.enums.State;

@Service
public class TaxService {

    public TaxCalculationResultDto calculateTax(TaxCalculationDto taxCalculationDto) {
        TaxStrategy strat;

        if (taxCalculationDto.getState() == State.SP) {
            strat = new SPTaxService();
        } else if (taxCalculationDto.getState() == State.RS) {
            strat = new RSTaxService();
        } else if (taxCalculationDto.getState() == State.PE) {
            strat = new PETaxService();
        } else {
            throw new IllegalArgumentException("Invalid state: " + taxCalculationDto.getState());
        }

        return strat.calculateTax(taxCalculationDto);
    }
}

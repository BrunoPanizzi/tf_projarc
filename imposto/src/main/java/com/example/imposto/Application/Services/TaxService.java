package com.example.imposto.Application.Services;

import org.springframework.stereotype.Service;

import com.example.imposto.presentation.dtos.TaxCalculationDto;
import com.example.imposto.presentation.dtos.TaxCalculationResultDto;
import com.example.imposto.presentation.dtos.enums.State;

@Service
public class TaxService {

    public TaxCalculationResultDto calculateTax(TaxCalculationDto taxCalculationDto) {
        TaxStrategy strat;

        if (taxCalculationDto.getState().equals(State.SAO_PAULO.getDisplayName())) {
            strat = new SPTaxService();
        } else if (taxCalculationDto.getState().equals(State.RIO_GRANDE_DO_SUL.getDisplayName())) {
            strat = new RSTaxService();
        } else if (taxCalculationDto.getState().equals(State.PERNAMBUCO.getDisplayName())) {
            strat = new PETaxService();
        } else {
            throw new IllegalArgumentException("Invalid state: " + taxCalculationDto.getState());
        }

        return strat.calculateTax(taxCalculationDto);
    }
}

package com.example.imposto.presentation.Controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.imposto.Application.Services.TaxService;
import com.example.imposto.presentation.dtos.TaxCalculationDto;
import com.example.imposto.presentation.dtos.TaxCalculationResultDto;

@RestController
@RequestMapping("/tax")
public class TaxController {
    private TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @PostMapping
    public TaxCalculationResultDto getTaxInfo(@Validated @RequestBody TaxCalculationDto taxCalculationDto) {
        return this.taxService.calculateTax(taxCalculationDto);
    }
}

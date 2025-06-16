package com.example.imposto.presentation.dtos;

import com.example.imposto.presentation.dtos.enums.State;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaxCalculationResultDto {
    private Double originalPrice;
    private Double finalPrice;
    private Double tax;

    private State state;
}

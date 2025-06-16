package com.example.imposto.presentation.dtos;

import java.util.List;

import com.example.imposto.presentation.dtos.enums.State;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxCalculationDto {
    private State state;
    private List<ProductDto> products;
}

package com.example.imposto.presentation.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxCalculationDto {
    private String state;
    private List<ProductDto> products;
}

package com.example.demo.Application.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaxRequestProductDto {
    private String description;
    private Double price;
    private Integer amount;
}

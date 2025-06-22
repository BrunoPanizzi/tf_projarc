package com.example.demo.Application.Dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaxRequestDto {
    private String state;
    private List<TaxRequestProductDto> products;
}

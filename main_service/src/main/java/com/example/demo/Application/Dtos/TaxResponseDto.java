package com.example.demo.Application.Dtos;

import com.example.demo.Domain.Enums.StateEnum;

import lombok.Data;

@Data
public class TaxResponseDto {
    private Double originalPrice;
    private Double finalPrice;
    private Double tax;

    private StateEnum state;
}

package com.example.demo.Application.Dtos;

import lombok.Data;

@Data
public class TaxResponseDto {
    private enum State {
        SP, RS, PE
    }

    private Double originalPrice;
    private Double finalPrice;
    private Double tax;

    private State state;
}

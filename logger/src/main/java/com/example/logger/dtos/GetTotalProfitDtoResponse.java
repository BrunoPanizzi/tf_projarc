package com.example.logger.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetTotalProfitDtoResponse {
    @NotNull Double totalProfit;
    @NotNull Double totalTax;
    
}

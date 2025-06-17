package com.example.logger.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApprovedQuotationDto {
    @NotNull
    private UUID id;
    @NotNull
    private String approvedAtIso;
    @NotNull
    private Double taxAmount;
    @NotNull
    private Double totalPrice;
}

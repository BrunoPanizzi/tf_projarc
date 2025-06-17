package com.example.logger.dtos;

import jakarta.validation.constraints.NotNull;

public record CreateApprovedQuotationDto(
    @NotNull String approvedAtIso,
    @NotNull Double taxAmount,
    @NotNull Double totalPrice
) {
}

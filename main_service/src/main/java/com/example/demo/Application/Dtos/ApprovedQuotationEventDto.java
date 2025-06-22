package com.example.demo.Application.Dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApprovedQuotationEventDto {
    private String id;
    private String approvedAtIso;
    private Double taxAmount;
    private Double totalPrice;
}

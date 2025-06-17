package com.example.logger.domain.entities;

import java.time.Instant;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApprovedQuotationEntity {

    private UUID id;
    private Instant approvedAt;
    private Double totalPrice;
    private Double taxAmount;
    
}
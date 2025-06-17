package com.example.logger.infraestructure.Models;

import java.time.Instant;
import java.util.UUID;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "approved_quotations")
@Getter
@Setter
public class ApprovedQuotation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Instant approvedAt;

    private Double taxAmount;

    private Double totalAmount;

    protected ApprovedQuotation() {
    }

    public ApprovedQuotation(Instant approvedAt, Double taxAmount, Double totalAmount) {
        this.approvedAt = approvedAt;
        this.taxAmount = taxAmount;
        this.totalAmount = totalAmount;
    }

}
package com.example.demo.Application.Events;

import java.time.Instant;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import com.example.demo.Application.Dtos.ApprovedQuotationDto;
import com.example.demo.Application.Dtos.ApprovedQuotationEventDto;

@Component
public class ApprovedQuotationEventPublisher {
    private final RabbitTemplate rabbitTemplate;

    public ApprovedQuotationEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendApprovedQuotation(ApprovedQuotationDto dto) {
        var payload = ApprovedQuotationEventDto.builder()
                .id(dto.getId().toString())
                .approvedAtIso(Instant.now().toString())
                .taxAmount(dto.getAppliedTax())
                .totalPrice(dto.getFinalPrice()).build();

        rabbitTemplate.convertAndSend("approved-quotation-queue", payload);
    }
}
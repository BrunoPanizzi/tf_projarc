package com.example.demo.Application.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Application.Dtos.TaxRequestDto;
import com.example.demo.Application.Dtos.TaxRequestProductDto;
import com.example.demo.Application.Dtos.TaxResponseDto;
import com.example.demo.Domain.Entities.QuotationEntity;

@Component
public class TaxService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${tax.service.url}")
    private String TAX_SERVICE_URL;

    public QuotationPriceInfo calculateTax(QuotationEntity quotationDto) {
        String url = TAX_SERVICE_URL + "/tax";

        var body = TaxRequestDto.builder()
                .products(quotationDto.getProducts().stream()
                        .map(product -> TaxRequestProductDto.builder()
                                .description(product.getProduct().getDescription())
                                .price(product.getProduct().getPrice())
                                .amount(product.getAmount())
                                .build())
                        .toList())
                .state(quotationDto.getState())
                .build();

        TaxResponseDto taxResponse = restTemplate.postForObject(url, body, TaxResponseDto.class);

        if (taxResponse == null || taxResponse.getTax() == null) {
            throw new IllegalStateException("Failed to calculate tax");
        }

        return QuotationPriceInfo.builder()
                .tax(taxResponse.getTax())
                .finalPrice(taxResponse.getFinalPrice())
                .discount(0.0).build();
    }
}

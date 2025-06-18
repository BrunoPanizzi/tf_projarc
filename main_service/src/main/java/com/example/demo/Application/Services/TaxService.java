package com.example.demo.Application.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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
        TaxResponseDto taxResponse = restTemplate.postForObject(url, quotationDto, TaxResponseDto.class);

        if (taxResponse == null || taxResponse.getTax() == null) {
            throw new IllegalStateException("Failed to calculate tax");
        }

        return QuotationPriceInfo.builder()
                .tax(taxResponse.getTax())
                .finalPrice(taxResponse.getFinalPrice())
                .discount(0.0).build();
    }
}

package com.example.logger.application.usecases;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import com.example.logger.domain.entities.ApprovedQuotationEntity;
import com.example.logger.dtos.GetTotalProfitDtoResponse;
import com.example.logger.infraestructure.Repositories.ApprovedQuotationRepository;

@Service
public class GetTotalProfitUsecase {
    private final ApprovedQuotationRepository approvedQuotationRepository;

    public GetTotalProfitUsecase(ApprovedQuotationRepository approvedQuotationRepository) {
        this.approvedQuotationRepository = approvedQuotationRepository;
    }

    public GetTotalProfitDtoResponse listTotalProfit(Integer monthNumber, Integer yearNumber) throws BadRequestException {
        if (monthNumber < 1 || monthNumber > 12) {
            throw new BadRequestException("Month number must be between 1 and 12");
        }

        if (yearNumber < 2000 || yearNumber > 2100) {
            throw new BadRequestException("Year number must be between 2000 and 2100");
        }
        
        List<ApprovedQuotationEntity> approvedQuotations = approvedQuotationRepository
                .listByMonthAndYear(monthNumber, yearNumber);

        Double totalProfit = approvedQuotations.stream()
                .mapToDouble(ApprovedQuotationEntity::getTotalPrice)
                .sum();
        Double totalTax = approvedQuotations.stream()
                .mapToDouble(ApprovedQuotationEntity::getTaxAmount)
                .sum();
    
        return new GetTotalProfitDtoResponse(totalProfit, totalTax);
    }
    
}

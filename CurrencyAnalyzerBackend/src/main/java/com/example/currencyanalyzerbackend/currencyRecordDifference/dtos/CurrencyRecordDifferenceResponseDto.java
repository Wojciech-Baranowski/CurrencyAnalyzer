package com.example.currencyanalyzerbackend.currencyRecordDifference.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyRecordDifferenceResponseDto {

    private LocalDate date;

    private Double bidPriceDifference;

    private Double salePriceDifference;
}

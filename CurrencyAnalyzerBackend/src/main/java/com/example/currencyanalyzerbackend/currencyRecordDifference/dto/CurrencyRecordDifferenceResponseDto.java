package com.example.currencyanalyzerbackend.currencyRecordDifference.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyRecordDifferenceResponseDto {

    private String date;

    private Double bidPriceDifference;

    private Double salePriceDifference;

}

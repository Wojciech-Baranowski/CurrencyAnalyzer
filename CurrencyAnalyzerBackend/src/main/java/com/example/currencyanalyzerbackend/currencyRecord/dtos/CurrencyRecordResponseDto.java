package com.example.currencyanalyzerbackend.currencyRecord.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyRecordResponseDto {

    private LocalDate date;

    private Double bidPrice;

    private Double salePrice;

}

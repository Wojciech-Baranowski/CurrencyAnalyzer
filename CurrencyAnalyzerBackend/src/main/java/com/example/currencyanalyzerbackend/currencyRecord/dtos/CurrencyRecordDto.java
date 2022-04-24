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
public class CurrencyRecordDto {

    private LocalDate date;

    private Double bidPrice;

    private Double salePrice;

    public CurrencyRecordDto(CurrencyRecordDto currencyRecord, LocalDate date){
        this.date = date;
        this.bidPrice = currencyRecord.getBidPrice();
        this.salePrice = currencyRecord.getSalePrice();
    }

}

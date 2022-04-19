package com.example.currencyanalyzerbackend.currencyRecord;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyRecord {

    private LocalDate date;

    private Double bidPrice;

    private Double salePrice;

    public CurrencyRecord(CurrencyRecord currencyRecord, LocalDate date){
        this.date = date;
        this.bidPrice = currencyRecord.getBidPrice();
        this.salePrice = currencyRecord.getSalePrice();
    }

}

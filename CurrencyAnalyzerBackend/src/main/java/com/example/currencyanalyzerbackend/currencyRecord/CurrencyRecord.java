package com.example.currencyanalyzerbackend.currencyRecord;

import com.example.currencyanalyzerbackend.currency.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyRecord {

    private Date date;

    private Double bidPrice;

    private Double salePrice;

    public CurrencyRecord(CurrencyRecord currencyRecord, Date date){
        this.date = date;
        this.bidPrice = currencyRecord.getBidPrice();
        this.salePrice = currencyRecord.getSalePrice();
    }

}

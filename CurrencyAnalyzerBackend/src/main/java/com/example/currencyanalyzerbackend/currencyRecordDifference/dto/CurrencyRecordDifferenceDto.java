package com.example.currencyanalyzerbackend.currencyRecordDifference.dto;

import com.example.currencyanalyzerbackend.currencyRecord.CurrencyRecord;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static com.example.currencyanalyzerbackend.numberRounder.NumberRounder.round;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyRecordDifferenceDto {

    private LocalDate date;

    private Double bidPriceDifference;

    private Double salePriceDifference;

    public CurrencyRecordDifferenceDto(CurrencyRecord record1, CurrencyRecord record2){
        date = record2.getDate();
        bidPriceDifference = round(record2.getBidPrice() - record1.getBidPrice(), 4);
        salePriceDifference = round(record2.getSalePrice() - record1.getSalePrice(), 4);
    }

}

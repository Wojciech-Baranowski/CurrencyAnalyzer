package com.example.currencyanalyzerbackend.currencyRecordDifference.dto;

import com.example.currencyanalyzerbackend.NumberRounder;
import com.example.currencyanalyzerbackend.currencyRecord.CurrencyRecord;
import com.example.currencyanalyzerbackend.date.DateMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyRecordDifferenceDto {

    private String date;

    private Double bidPriceDifference;

    private Double salePriceDifference;

    public CurrencyRecordDifferenceDto(CurrencyRecord record1, CurrencyRecord record2){
        date = DateMapper.dateToStringDayFirst(record2.getDate());
        bidPriceDifference = NumberRounder.round(record2.getBidPrice() - record1.getBidPrice(), 4);
        salePriceDifference = NumberRounder.round(record2.getSalePrice() - record1.getSalePrice(), 4);
    }

}

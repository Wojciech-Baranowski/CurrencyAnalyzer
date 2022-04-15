package com.example.currencyanalyzerbackend.currencyRecord.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyRecordDto {

    private Date date;
    private Double bidPrice;
    private Double salePrice;

}

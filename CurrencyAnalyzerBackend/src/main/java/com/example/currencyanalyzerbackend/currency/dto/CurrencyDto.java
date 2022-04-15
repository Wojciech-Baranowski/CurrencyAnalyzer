package com.example.currencyanalyzerbackend.currency.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyDto {

    private String code;
    private String name;
    private List<CurrencyRecordDto> records;

}

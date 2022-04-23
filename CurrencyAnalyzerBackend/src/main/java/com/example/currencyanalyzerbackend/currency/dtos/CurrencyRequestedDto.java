package com.example.currencyanalyzerbackend.currency.dtos;

import com.example.currencyanalyzerbackend.currencyRecord.dtos.CurrencyRecordRequestedDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyRequestedDto {

    @JsonProperty("table")
    private String tableId;

    @JsonProperty("currency")
    private String name;

    private String code;

    @JsonProperty("rates")
    private List<CurrencyRecordRequestedDto> records;


}

package com.example.currencyanalyzerbackend.currency.dto;

import com.example.currencyanalyzerbackend.currencyRecord.dto.CurrencyRecordDto;
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

    private String name;

    private String code;

    private List<CurrencyRecordDto> records;

}

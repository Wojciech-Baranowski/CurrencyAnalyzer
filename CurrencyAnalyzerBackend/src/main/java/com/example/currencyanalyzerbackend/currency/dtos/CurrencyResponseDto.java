package com.example.currencyanalyzerbackend.currency.dtos;

import com.example.currencyanalyzerbackend.currencyRecord.dtos.CurrencyRecordResponseDto;
import com.example.currencyanalyzerbackend.currencyRecordDifference.dtos.CurrencyRecordDifferenceResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyResponseDto {

    private String name;

    private String code;

    private List<CurrencyRecordResponseDto> records;

    private List<CurrencyRecordDifferenceResponseDto> recordsDifferences;
}

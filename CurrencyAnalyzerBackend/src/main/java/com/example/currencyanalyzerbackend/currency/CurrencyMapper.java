package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.currency.dto.CurrencyRequestedDto;
import com.example.currencyanalyzerbackend.currency.dto.CurrencyResponseDto;
import com.example.currencyanalyzerbackend.currencyRecord.CurrencyRecordMapper;
import com.example.currencyanalyzerbackend.currencyRecordDifference.CurrencyRecordDifferenceMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CurrencyMapper {

    public static Currency requestedDtoToObject(CurrencyRequestedDto requestedDto){
        return Currency.builder()
                .name(requestedDto.getName())
                .code(requestedDto.getCode())
                .records(CurrencyRecordMapper.requestedDtoListToObjectList(requestedDto.getRecords()))
                .build();
    }

    public static CurrencyResponseDto objectToResponseDto(Currency currency){
        return CurrencyResponseDto.builder()
                .name(currency.getName())
                .code(currency.getCode())
                .records(CurrencyRecordMapper.objectListToResponseDtoList(currency.getRecords()))
                .recordsDifferences(
                        CurrencyRecordDifferenceMapper.dtoListToResponseDtoList(currency.getRecordsDifferences()))
                .build();
    }

    public static CurrencyRequestedDto jsonStringToRequestedDto(String jsonString) {
        try {
            return new ObjectMapper().readValue(jsonString, CurrencyRequestedDto.class);
        } catch (JsonProcessingException e) {
            //TODO: data not found error
            throw new RuntimeException(e);
        }
    }

}

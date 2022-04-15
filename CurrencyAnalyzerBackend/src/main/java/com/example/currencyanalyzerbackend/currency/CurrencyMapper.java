package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.currency.dto.CurrencyDto;
import com.example.currencyanalyzerbackend.currency.dto.CurrencyRequestedDto;
import com.example.currencyanalyzerbackend.currency.dto.CurrencyResponseDto;
import com.example.currencyanalyzerbackend.currencyRecord.CurrencyRecordMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Currency;

public class CurrencyMapper {

    public static CurrencyDto requestedDtoToDto(CurrencyRequestedDto requestedDto){
        return CurrencyDto.builder()
                .name(requestedDto.getName())
                .code(requestedDto.getCode())
                .records(CurrencyRecordMapper.requestedDtoListToDtoList(requestedDto.getRecords()))
                .build();
    }

    public static CurrencyResponseDto dtoToResponseDto(CurrencyDto dto){
        return CurrencyResponseDto.builder()
                .name(dto.getName())
                .code(dto.getCode())
                .records(CurrencyRecordMapper.dtoListToResponseDtoList(dto.getRecords()))
                .build();
    }

    public static CurrencyRequestedDto jsonStringToRequestedDto(String jsonString) {
        try {
            return new ObjectMapper().readValue(jsonString, CurrencyRequestedDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}

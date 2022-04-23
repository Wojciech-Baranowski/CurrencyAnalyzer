package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.currency.dtos.CurrencyRequestedDto;
import com.example.currencyanalyzerbackend.currency.dtos.CurrencyResponseDto;
import com.example.currencyanalyzerbackend.exceptions.BadRequestException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.example.currencyanalyzerbackend.currencyRecord.CurrencyRecordMapper.objectListToResponseDtoList;
import static com.example.currencyanalyzerbackend.currencyRecord.CurrencyRecordMapper.requestedDtoListToObjectList;
import static com.example.currencyanalyzerbackend.currencyRecordDifference.CurrencyRecordDifferenceMapper.dtoListToResponseDtoList;

public class CurrencyMapper {

    public static Currency requestedDtoToObject(CurrencyRequestedDto requestedDto){
        return Currency.builder()
                .name(requestedDto.getName())
                .code(requestedDto.getCode())
                .records(requestedDtoListToObjectList(requestedDto.getRecords()))
                .build();
    }

    public static CurrencyResponseDto objectToResponseDto(Currency currency){
        return CurrencyResponseDto.builder()
                .name(currency.getName())
                .code(currency.getCode())
                .records(objectListToResponseDtoList(currency.getRecords()))
                .recordsDifferences(dtoListToResponseDtoList(currency.getRecordsDifferences()))
                .build();
    }

    public static CurrencyRequestedDto jsonStringToRequestedDto(String jsonString) {
        try {
            return new ObjectMapper().readValue(jsonString, CurrencyRequestedDto.class);
        } catch (JsonProcessingException e) {
            throw new BadRequestException("Invalid request data");
        }
    }

}

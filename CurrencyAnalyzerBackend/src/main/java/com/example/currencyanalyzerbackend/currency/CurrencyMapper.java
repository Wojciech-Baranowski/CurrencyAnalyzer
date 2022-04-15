package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.currency.dto.CurrencyDto;
import com.example.currencyanalyzerbackend.currency.dto.CurrencyRequestedDto;
import com.example.currencyanalyzerbackend.currencyRecord.CurrencyRecordMapper;

public class CurrencyMapper {

    public static CurrencyDto requestedDtoToDto(CurrencyRequestedDto requestedDto){
        return CurrencyDto.builder()
                .name(requestedDto.getName())
                .code(requestedDto.getCode())
                .records(CurrencyRecordMapper.requestedDtoListToDtoList(requestedDto.getRecords()))
                .build();
    }
}

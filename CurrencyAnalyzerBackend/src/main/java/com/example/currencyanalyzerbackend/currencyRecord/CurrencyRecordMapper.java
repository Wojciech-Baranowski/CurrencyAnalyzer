package com.example.currencyanalyzerbackend.currencyRecord;

import com.example.currencyanalyzerbackend.currencyRecord.dto.CurrencyRecordDto;
import com.example.currencyanalyzerbackend.currencyRecord.dto.CurrencyRecordRequestedDto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CurrencyRecordMapper {

    public static CurrencyRecordDto requestedDtoToDto(CurrencyRecordRequestedDto requestedDto){
        return CurrencyRecordDto.builder()
                .date(requestedDto.getDate())
                .bidPrice(requestedDto.getBidPrice())
                .salePrice(requestedDto.getSalePrice())
                .build();
    }

    public static List<CurrencyRecordDto> requestedDtoListToDtoList(List<CurrencyRecordRequestedDto> requestedDtos){
        return requestedDtos.stream()
                .map(CurrencyRecordMapper::requestedDtoToDto)
                .collect(Collectors.toList());
    }

}

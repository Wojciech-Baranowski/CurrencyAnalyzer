package com.example.currencyanalyzerbackend.currencyRecord;

import com.example.currencyanalyzerbackend.currencyRecord.dto.CurrencyRecordRequestedDto;
import com.example.currencyanalyzerbackend.currencyRecord.dto.CurrencyRecordResponseDto;
import com.example.currencyanalyzerbackend.data.DateService;

import java.util.List;
import java.util.stream.Collectors;

public class CurrencyRecordMapper {

    public static List<CurrencyRecord> requestedDtoListToObjectList(List<CurrencyRecordRequestedDto> requestedDtos){
        return requestedDtos.stream()
                .map(CurrencyRecordMapper::requestedDtoToObject)
                .collect(Collectors.toList());
    }

    public static CurrencyRecord requestedDtoToObject(CurrencyRecordRequestedDto requestedDto){
        return CurrencyRecord.builder()
                .date(DateService.dateToLocalDate(requestedDto.getDate()))
                .bidPrice(requestedDto.getBidPrice())
                .salePrice(requestedDto.getSalePrice())
                .build();
    }

    public static List<CurrencyRecordResponseDto> objectListToResponseDtoList(List<CurrencyRecord> records){
        return records.stream()
                .map(CurrencyRecordMapper::objectToResponseDto)
                .collect(Collectors.toList());
    }

    public static CurrencyRecordResponseDto objectToResponseDto(CurrencyRecord record){
        return CurrencyRecordResponseDto.builder()
                .date(record.getDate())
                .bidPrice(record.getBidPrice())
                .salePrice(record.getSalePrice())
                .build();
    }



}

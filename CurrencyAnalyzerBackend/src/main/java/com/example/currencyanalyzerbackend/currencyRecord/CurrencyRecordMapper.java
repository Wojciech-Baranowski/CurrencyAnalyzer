package com.example.currencyanalyzerbackend.currencyRecord;

import com.example.currencyanalyzerbackend.currencyRecord.dtos.CurrencyRecordDto;
import com.example.currencyanalyzerbackend.currencyRecord.dtos.CurrencyRecordRequestedDto;
import com.example.currencyanalyzerbackend.currencyRecord.dtos.CurrencyRecordResponseDto;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.currencyanalyzerbackend.date.DateMapper.dateToLocalDate;

public class CurrencyRecordMapper {

    public static List<CurrencyRecordDto> requestedDtoListToDtoList(List<CurrencyRecordRequestedDto> requestedDtos){
        return requestedDtos.stream()
                .map(CurrencyRecordMapper::requestedDtoToDto)
                .collect(Collectors.toList());
    }

    public static CurrencyRecordDto requestedDtoToDto(CurrencyRecordRequestedDto requestedDto){
        return CurrencyRecordDto.builder()
                .date(dateToLocalDate(requestedDto.getDate()))
                .bidPrice(requestedDto.getBidPrice())
                .salePrice(requestedDto.getSalePrice())
                .build();
    }

    public static List<CurrencyRecordResponseDto> dtoListToResponseDtoList(List<CurrencyRecordDto> records){
        return records.stream()
                .map(CurrencyRecordMapper::dtoToResponseDto)
                .collect(Collectors.toList());
    }

    public static CurrencyRecordResponseDto dtoToResponseDto(CurrencyRecordDto record){
        return CurrencyRecordResponseDto.builder()
                .date(record.getDate())
                .bidPrice(record.getBidPrice())
                .salePrice(record.getSalePrice())
                .build();
    }



}

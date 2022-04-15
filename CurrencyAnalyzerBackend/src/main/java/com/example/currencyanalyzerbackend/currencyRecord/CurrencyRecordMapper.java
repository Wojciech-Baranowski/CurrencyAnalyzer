package com.example.currencyanalyzerbackend.currencyRecord;

import com.example.currencyanalyzerbackend.currencyRecord.dto.CurrencyRecordDto;
import com.example.currencyanalyzerbackend.currencyRecord.dto.CurrencyRecordRequestedDto;
import com.example.currencyanalyzerbackend.currencyRecord.dto.CurrencyRecordResponseDto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CurrencyRecordMapper {

    private static final String datePattern = "dd-MM-yyyy";

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);

    public static List<CurrencyRecordDto> requestedDtoListToDtoList(List<CurrencyRecordRequestedDto> requestedDtos){
        return requestedDtos.stream()
                .map(CurrencyRecordMapper::requestedDtoToDto)
                .collect(Collectors.toList());
    }

    public static CurrencyRecordDto requestedDtoToDto(CurrencyRecordRequestedDto requestedDto){
        return CurrencyRecordDto.builder()
                .date(requestedDto.getDate())
                .bidPrice(requestedDto.getBidPrice())
                .salePrice(requestedDto.getSalePrice())
                .build();
    }

    public static List<CurrencyRecordResponseDto> dtoListToResponseDtoList(List<CurrencyRecordDto> dtos){
        return dtos.stream()
                .map(CurrencyRecordMapper::dtoToResponseDto)
                .collect(Collectors.toList());
    }

    public static CurrencyRecordResponseDto dtoToResponseDto(CurrencyRecordDto dto){
        return CurrencyRecordResponseDto.builder()
                .date(dateToDateFormattedString(dto.getDate()))
                .bidPrice(dto.getBidPrice())
                .salePrice(dto.getSalePrice())
                .build();
    }

    private static String dateToDateFormattedString(Date date){
        return dateFormat.format(date);
    }

}

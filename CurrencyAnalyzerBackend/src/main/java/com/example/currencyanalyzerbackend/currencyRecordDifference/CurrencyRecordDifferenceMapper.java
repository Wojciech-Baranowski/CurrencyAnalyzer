package com.example.currencyanalyzerbackend.currencyRecordDifference;

import com.example.currencyanalyzerbackend.currencyRecordDifference.dto.CurrencyRecordDifferenceDto;
import com.example.currencyanalyzerbackend.currencyRecordDifference.dto.CurrencyRecordDifferenceResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class CurrencyRecordDifferenceMapper {

    public static List<CurrencyRecordDifferenceResponseDto> dtoListToResponseDtoList(
            List<CurrencyRecordDifferenceDto> dtos){
        return dtos.stream()
                .map(CurrencyRecordDifferenceMapper::dtoToResponseDto)
                .collect(Collectors.toList());
    }

    public static CurrencyRecordDifferenceResponseDto dtoToResponseDto(CurrencyRecordDifferenceDto dto){
        return CurrencyRecordDifferenceResponseDto.builder()
                .date(dto.getDate())
                .bidPriceDifference(dto.getBidPriceDifference())
                .salePriceDifference(dto.getSalePriceDifference())
                .build();
    }

}

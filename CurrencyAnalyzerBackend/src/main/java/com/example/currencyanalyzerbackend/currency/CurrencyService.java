package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.currency.dto.CurrencyDto;
import com.example.currencyanalyzerbackend.currency.dto.CurrencyRequestedDto;
import com.example.currencyanalyzerbackend.currency.dto.CurrencyResponseDto;
import com.example.currencyanalyzerbackend.currencyRecord.dto.CurrencyRecordDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CurrencyService {

    private final CurrencyRequester currencyRequester;

    public CurrencyResponseDto getCurrencyRecords(String currencyCode, Integer numberOfDays){
        CurrencyRequestedDto requestedDto = currencyRequester.getRequestedCurrency(currencyCode, numberOfDays);
        CurrencyDto dto = CurrencyMapper.requestedDtoToDto(requestedDto);
        return CurrencyMapper.dtoToResponseDto(dto);
    }

}

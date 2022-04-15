package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.currency.dto.CurrencyDto;
import com.example.currencyanalyzerbackend.currency.dto.CurrencyRequestedDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CurrencyService {

    private final CurrencyRequester currencyRequester;

    public CurrencyDto getCurrencyRecords(String currencyCode, Integer numberOfDays){
        CurrencyRequestedDto requestedDto = currencyRequester.getRequestedCurrency(currencyCode, numberOfDays);
        return CurrencyMapper.requestedDtoToDto(requestedDto);
    }

}

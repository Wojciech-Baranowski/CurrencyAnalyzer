package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.date.RequestDataDto;
import com.example.currencyanalyzerbackend.currency.dto.CurrencyRequestedDto;
import com.example.currencyanalyzerbackend.currency.dto.CurrencyResponseDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CurrencyService {

    private final CurrencyRequester currencyRequester;

    public CurrencyResponseDto getCurrencyRecords(RequestDataDto requestDataDto){
        CurrencyRequestedDto requestedDto = currencyRequester.getRequestedCurrency(requestDataDto);
        Currency currency = CurrencyMapper.requestedDtoToObject(requestedDto);
        currency.setRecordsDifferences();
        return CurrencyMapper.objectToResponseDto(currency);
    }

}

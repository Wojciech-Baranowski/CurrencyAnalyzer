package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.currency.dto.CurrencyRequestedDto;
import com.example.currencyanalyzerbackend.currency.dto.CurrencyResponseDto;
import com.example.currencyanalyzerbackend.data.RequestDataDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CurrencyService {

    private final CurrencyRequester currencyRequester;
    private final CurrencyRequestValidator currencyRequestValidator;

    public CurrencyResponseDto getCurrencyRecords(RequestDataDto requestDataDto){
        currencyRequestValidator.validate(requestDataDto);
        return getCurrencyResponseDto(requestDataDto);
    }

    private CurrencyResponseDto getCurrencyResponseDto(RequestDataDto requestDataDto){
        CurrencyRequestedDto requestedDto = currencyRequester.getRequestedCurrency(requestDataDto);
        Currency currency = CurrencyMapper.requestedDtoToObject(requestedDto);
        currency.fillEmptyDays(requestDataDto);
        currency.trimRecordsToStartDate(requestDataDto.getStartDate());
        currency.setRecordsDifferences();
        return CurrencyMapper.objectToResponseDto(currency);
    }

}

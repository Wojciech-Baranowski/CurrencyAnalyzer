package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.currency.dtos.CurrencyRequestedDto;
import com.example.currencyanalyzerbackend.currency.dtos.CurrencyResponseDto;
import com.example.currencyanalyzerbackend.data.RequestDataDto;
import lombok.AllArgsConstructor;

import static com.example.currencyanalyzerbackend.currency.CurrencyMapper.objectToResponseDto;
import static com.example.currencyanalyzerbackend.currency.CurrencyMapper.requestedDtoToObject;
import static com.example.currencyanalyzerbackend.data.RequestDataService.weekEarlier;

@AllArgsConstructor
public class CurrencyService {

    private final CurrencyRequester currencyRequester;
    private final CurrencyRequestValidator currencyRequestValidator;

    CurrencyResponseDto getCurrencyRecords(RequestDataDto requestDataDto) {
        currencyRequestValidator.validate(requestDataDto);
        return getCurrencyResponseDto(requestDataDto);
    }

    private CurrencyResponseDto getCurrencyResponseDto(RequestDataDto requestDataDto) {
        CurrencyRequestedDto requestedDto = currencyRequester.getRequestedCurrency(weekEarlier(requestDataDto));
        Currency currency = requestedDtoToObject(requestedDto);
        currency.fillEmptyDays(requestDataDto);
        currency.trimRecordsToStartDate(requestDataDto.getStartDate());
        currency.setRecordsDifferences();
        return objectToResponseDto(currency);
    }
}

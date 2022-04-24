package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.currency.currencyRequesterTestDtos.GetRequestedCurrencyTestDto;
import com.example.currencyanalyzerbackend.currency.dtos.CurrencyRequestedDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.currencyanalyzerbackend.TestLoader.loadTests;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrencyRequesterTest {

    @Test
    public void get_requested_currency_test(){
        //given
        CurrencyRequester currencyRequester = new CurrencyRequester();
        String testPath = "getRequestedCurrencyTests.json";
        List<GetRequestedCurrencyTestDto> testDtos = loadTests(testPath, GetRequestedCurrencyTestDto[].class);

        //when
        List<CurrencyRequestedDto> results = testDtos.stream()
                .map(GetRequestedCurrencyTestDto::getRequestDataDto)
                .map(currencyRequester::getRequestedCurrency)
                .toList();

        //then
        assertEquals(
                testDtos.stream()
                        .map(GetRequestedCurrencyTestDto::getRequestedDataDto)
                        .toList(),
                results);
    }
}

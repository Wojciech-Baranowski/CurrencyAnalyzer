package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.currency.currencyTestDtos.FillEmptyDaysTestDto;
import com.example.currencyanalyzerbackend.currency.currencyTestDtos.SetRecordsDifferencesTestDto;
import com.example.currencyanalyzerbackend.currency.currencyTestDtos.TrimRecordsToStartDateTestDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.currencyanalyzerbackend.TestLoader.loadTests;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrencyTest {

    @Test
    public void trim_records_to_start_date_test() {
        //given
        String testPath = "trimRecordsToStartDateTests.json";
        List<TrimRecordsToStartDateTestDto> testDtos = loadTests(testPath, TrimRecordsToStartDateTestDto[].class);

        //when
        testDtos.forEach((TrimRecordsToStartDateTestDto test) ->
                test.getCurrencyInput().trimRecordsToStartDate(test.getStartDate()));
        List<Currency> results = testDtos.stream()
                .map(TrimRecordsToStartDateTestDto::getCurrencyInput)
                .toList();

        //then
        assertEquals(
                testDtos.stream()
                        .map(TrimRecordsToStartDateTestDto::getCurrencyOutput)
                        .toList(),
                results
        );
    }

    @Test
    public void set_records_differences_test() {
        //given
        String testPath = "setRecordsDifferencesTests.json";
        List<SetRecordsDifferencesTestDto> testDtos = loadTests(testPath, SetRecordsDifferencesTestDto[].class);

        //when
        testDtos.forEach((SetRecordsDifferencesTestDto test) -> test.getCurrencyInput().setRecordsDifferences());
        List<Currency> results = testDtos.stream()
                .map(SetRecordsDifferencesTestDto::getCurrencyInput)
                .toList();

        //then
        assertEquals(
                testDtos.stream()
                        .map(SetRecordsDifferencesTestDto::getCurrencyOutput)
                        .toList(),
                results
        );
    }

    @Test
    public void fill_empty_days_test(){
        //given
        String testPath = "fillEmptyDaysTests.json";
        List<FillEmptyDaysTestDto> testDtos = loadTests(testPath, FillEmptyDaysTestDto[].class);

        //when
        testDtos.forEach((FillEmptyDaysTestDto test) ->
                test.getCurrencyInput().fillEmptyDays(test.getRequestDataDto()));
        List<Currency> results = testDtos.stream()
                .map(FillEmptyDaysTestDto::getCurrencyInput)
                .toList();

        //then
        assertEquals(
                testDtos.stream()
                        .map(FillEmptyDaysTestDto::getCurrencyOutput)
                        .toList(),
                results
        );
    }

}

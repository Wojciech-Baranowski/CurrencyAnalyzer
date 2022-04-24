package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.currency.currencyRequesterValidatorTestDtos.ValidateTestDto;
import com.example.currencyanalyzerbackend.exceptions.BadRequestException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.currencyanalyzerbackend.TestLoader.loadTests;
import static org.junit.jupiter.api.Assertions.*;

public class CurrencyRequestValidatorTest {
    @Test
    public void validate_test(){
        //given
        CurrencyRequestValidator currencyRequestValidator = new CurrencyRequestValidator();
        String testPath = "validateTests.json";
        List<ValidateTestDto> testDtos = loadTests(testPath, ValidateTestDto[].class);

        //then
        for(ValidateTestDto requestDataDto : testDtos){
            BadRequestException exception = assertThrows(
                    BadRequestException.class,
                    () -> currencyRequestValidator.validate(requestDataDto.getRequestDataDto())
            );
            assertEquals(requestDataDto.getError(), exception.getMessage());
        }
    }

}

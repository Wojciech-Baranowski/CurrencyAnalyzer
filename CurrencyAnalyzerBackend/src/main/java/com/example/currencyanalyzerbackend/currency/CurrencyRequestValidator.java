package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.data.RequestDataDto;
import com.example.currencyanalyzerbackend.exceptions.BadRequestException;

import java.time.LocalDate;

public class CurrencyRequestValidator {

    public void validate(RequestDataDto requestDataDto){
        if(isFirstDateAfterSecond(requestDataDto))
            throw new BadRequestException("Invalid date order");
        if(isStartDateTooEarly(requestDataDto))
            throw new BadRequestException("Invalid start date");
        if(isEndDateTooLate(requestDataDto))
            throw new BadRequestException("Invalid end date");
    }

    private boolean isFirstDateAfterSecond(RequestDataDto requestDataDto){
        LocalDate startDate = requestDataDto.getStartDate();
        LocalDate endDate = requestDataDto.getEndDate();
        return endDate.isBefore(startDate);
    }

    private boolean isStartDateTooEarly(RequestDataDto requestDataDto){
        LocalDate startDate = requestDataDto.getStartDate();
        LocalDate firstPossibleDate = LocalDate.of(2005, 1, 1);
        return firstPossibleDate.isAfter(startDate);
    }

    private boolean isEndDateTooLate(RequestDataDto requestDataDto){
        LocalDate endDate = requestDataDto.getEndDate();
        LocalDate currentDate = LocalDate.now();
        return currentDate.isBefore(endDate);
    }
}

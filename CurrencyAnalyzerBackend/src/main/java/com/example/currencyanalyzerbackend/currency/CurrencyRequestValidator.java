package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.date.DateMapper;
import com.example.currencyanalyzerbackend.date.DateService;
import com.example.currencyanalyzerbackend.date.RequestDataDto;
import com.example.currencyanalyzerbackend.exceptions.BadRequestException;

import java.util.Date;

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
        Date startDate = DateMapper.stringToDate(requestDataDto.getStartDate());
        Date endDate = DateMapper.stringToDate(requestDataDto.getEndDate());
        return endDate.before(startDate);
    }

    private boolean isStartDateTooEarly(RequestDataDto requestDataDto){
        Date startDate = DateMapper.stringToDate(requestDataDto.getStartDate());
        Date firstPossibleDate = new Date(DateService.TIME_IN_MILLISECONDS_FROM_EPOCH_TO_2005);
        return firstPossibleDate.after(startDate);
    }

    private boolean isEndDateTooLate(RequestDataDto requestDataDto){
        Date endDate = DateMapper.stringToDate(requestDataDto.getEndDate());
        Date currentDate = new Date();
        return currentDate.before(endDate);
    }
}

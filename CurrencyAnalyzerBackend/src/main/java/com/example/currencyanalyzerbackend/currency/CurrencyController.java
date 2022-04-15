package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.date.RequestDataDto;
import com.example.currencyanalyzerbackend.currency.dto.CurrencyResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/currency")
@AllArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping(path = "/{currencyCode}/{startDate}/{endDate}")
    public CurrencyResponseDto getCurrencyRecords(
            @PathVariable String currencyCode,
            @PathVariable String startDate,
            @PathVariable String endDate
    ){
        RequestDataDto requestDataDto = new RequestDataDto(currencyCode, startDate, endDate);
        return currencyService.getCurrencyRecords(requestDataDto);
    }

}

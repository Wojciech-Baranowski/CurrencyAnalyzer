package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.currency.dto.CurrencyDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("path = /currency")
@AllArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping(path = "/{currencyCode}/{numberOfDays}")
    public CurrencyDto getCurrencyRecords(@PathVariable String currencyCode, @PathVariable Integer numberOfDays){
        return currencyService.getCurrencyRecords(currencyCode, numberOfDays);
    }

}

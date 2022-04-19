package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.data.RequestDataDto;
import com.example.currencyanalyzerbackend.currency.dto.CurrencyResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/currency")
@AllArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;
    @PostMapping
    public CurrencyResponseDto getCurrencyRecords(@RequestBody RequestDataDto requestDataDto){
        return currencyService.getCurrencyRecords(requestDataDto);
    }

}

package com.example.currencyanalyzerbackend.currency;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("path = /currency")
@AllArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;



}

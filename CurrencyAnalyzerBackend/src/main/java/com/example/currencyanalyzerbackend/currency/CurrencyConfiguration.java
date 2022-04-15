package com.example.currencyanalyzerbackend.currency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CurrencyConfiguration {

    @Bean
    CurrencyService currencyService(){
        CurrencyRequester currencyRequester = new CurrencyRequester();
        return new CurrencyService(currencyRequester);
    }
}

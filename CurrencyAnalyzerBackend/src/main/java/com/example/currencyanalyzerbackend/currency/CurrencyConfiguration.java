package com.example.currencyanalyzerbackend.currency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CurrencyConfiguration {

    @Bean
    public CurrencyRequester currencyRequester(){
        return new CurrencyRequester();
    }

    @Bean
    public CurrencyService currencyService(CurrencyRequester currencyRequester){
        return new CurrencyService(currencyRequester);
    }

}

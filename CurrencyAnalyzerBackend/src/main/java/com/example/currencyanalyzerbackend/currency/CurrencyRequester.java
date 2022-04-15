package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.currency.dto.CurrencyRequestedDto;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyRequester {

    private static final String URL_PREFIX = "http://api.nbp.pl/api/exchangerates/rates/C/";
    private static final String URL_INFIX = "/last/";
    private final HttpClient client;
    public CurrencyRequester(){
        client = HttpClient.newHttpClient();
    }
    public CurrencyRequestedDto getRequestedCurrency(String currencyCode, Integer numberOfDays) {
        HttpRequest request = createRequest(currencyCode, numberOfDays);
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(CurrencyMapper::jsonStringToRequestedDto)
                .join();
    }

    private HttpRequest createRequest(String currencyCode, Integer numberOfDays){
        String url = createUrl(currencyCode, numberOfDays);
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
    }
    private String createUrl(String currencyCode, Integer numberOfDays){
        return new StringBuffer()
                .append(URL_PREFIX)
                .append(currencyCode)
                .append(URL_INFIX)
                .append(numberOfDays)
                .toString();
    }
}

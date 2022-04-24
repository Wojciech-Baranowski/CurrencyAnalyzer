package com.example.currencyanalyzerbackend.data;

public class RequestDataService {

    public static RequestDataDto weekEarlier(RequestDataDto requestDataDto) {
        return RequestDataDto.builder()
                .currencyCode(requestDataDto.getCurrencyCode())
                .startDate(requestDataDto.getStartDate().minusWeeks(1))
                .endDate(requestDataDto.getEndDate())
                .build();
    }
}

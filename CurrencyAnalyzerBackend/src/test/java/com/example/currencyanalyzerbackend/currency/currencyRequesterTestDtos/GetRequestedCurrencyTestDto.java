package com.example.currencyanalyzerbackend.currency.currencyRequesterTestDtos;

import com.example.currencyanalyzerbackend.currency.dtos.CurrencyRequestedDto;
import com.example.currencyanalyzerbackend.data.RequestDataDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetRequestedCurrencyTestDto {

    private RequestDataDto requestDataDto;

    private CurrencyRequestedDto requestedDataDto;
}

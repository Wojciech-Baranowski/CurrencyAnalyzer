package com.example.currencyanalyzerbackend.currency.currencyTestDtos;

import com.example.currencyanalyzerbackend.currency.Currency;
import com.example.currencyanalyzerbackend.data.RequestDataDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FillEmptyDaysTestDto {

    private Currency currencyInput;
    private RequestDataDto requestDataDto;
    private Currency currencyOutput;

}

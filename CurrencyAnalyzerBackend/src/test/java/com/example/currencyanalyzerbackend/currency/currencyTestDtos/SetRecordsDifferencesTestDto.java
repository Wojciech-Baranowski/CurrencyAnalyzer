package com.example.currencyanalyzerbackend.currency.currencyTestDtos;

import com.example.currencyanalyzerbackend.currency.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SetRecordsDifferencesTestDto {

    private Currency currencyInput;

    private Currency currencyOutput;
}

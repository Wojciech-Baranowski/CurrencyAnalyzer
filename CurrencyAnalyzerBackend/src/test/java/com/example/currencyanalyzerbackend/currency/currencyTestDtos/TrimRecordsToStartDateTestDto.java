package com.example.currencyanalyzerbackend.currency.currencyTestDtos;

import com.example.currencyanalyzerbackend.currency.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrimRecordsToStartDateTestDto {

    private Currency currencyInput;
    private LocalDate startDate;
    private Currency currencyOutput;

}

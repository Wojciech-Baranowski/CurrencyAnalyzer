package com.example.currencyanalyzerbackend.currency.currencyRequesterValidatorTestDtos;

import com.example.currencyanalyzerbackend.data.RequestDataDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidateTestDto {

    private RequestDataDto requestDataDto;
    private String error;

}

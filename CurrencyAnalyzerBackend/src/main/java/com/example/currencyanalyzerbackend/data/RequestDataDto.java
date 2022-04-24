package com.example.currencyanalyzerbackend.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestDataDto {

    String currencyCode;

    LocalDate startDate;

    LocalDate endDate;

}

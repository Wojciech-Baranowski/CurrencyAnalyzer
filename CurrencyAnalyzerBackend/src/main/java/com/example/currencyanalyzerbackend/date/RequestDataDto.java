package com.example.currencyanalyzerbackend.date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestDataDto {

    String currencyCode;

    String startDate;

    String endDate;
}

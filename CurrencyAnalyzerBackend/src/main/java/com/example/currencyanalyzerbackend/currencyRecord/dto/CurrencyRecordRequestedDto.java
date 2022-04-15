package com.example.currencyanalyzerbackend.currencyRecord.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyRecordRequestedDto {

    @JsonProperty("no")
    private String id;

    @JsonProperty("effectiveDate")
    private Date date;

    @JsonProperty("bid")
    private Double bidPrice;

    @JsonProperty("ask")
    private Double salePrice;

}

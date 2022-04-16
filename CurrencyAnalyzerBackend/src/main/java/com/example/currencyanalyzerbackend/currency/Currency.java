package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.currencyRecord.CurrencyRecord;
import com.example.currencyanalyzerbackend.currencyRecordDifference.CurrencyRecordDifferenceMapper;
import com.example.currencyanalyzerbackend.currencyRecordDifference.dto.CurrencyRecordDifferenceDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.max;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Currency {

    private String name;
    private String code;
    private List<CurrencyRecord> records;
    private List<CurrencyRecordDifferenceDto> recordsDifferences;

    public void setRecordsDifferences(){
        recordsDifferences = new LinkedList<>();
        for(int i = 1; i < records.size(); i++){
            recordsDifferences.add(new CurrencyRecordDifferenceDto(records.get(i - 1), records.get(i)));
        }
    }

}

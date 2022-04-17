package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.currencyRecord.CurrencyRecord;
import com.example.currencyanalyzerbackend.currencyRecordDifference.CurrencyRecordDifferenceMapper;
import com.example.currencyanalyzerbackend.currencyRecordDifference.dto.CurrencyRecordDifferenceDto;
import com.example.currencyanalyzerbackend.date.DateMapper;
import com.example.currencyanalyzerbackend.date.DateService;
import com.example.currencyanalyzerbackend.date.RequestDataDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.currencyanalyzerbackend.date.DateMapper.stringToDate;
import static com.example.currencyanalyzerbackend.date.DateService.dayAfter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Currency {

    private String name;
    private String code;
    private List<CurrencyRecord> records;
    private List<CurrencyRecordDifferenceDto> recordsDifferences;

    public void fillEmptyDays(RequestDataDto fullRequestDataDto){
        Date startDate = records.get(0).getDate();
        Date endDate = stringToDate(fullRequestDataDto.getEndDate());
        List<CurrencyRecord> missedRecords = new LinkedList<>();
        int listElementIndex = 0;

        for(Date date = startDate; date.getTime() < dayAfter(endDate).getTime(); date = dayAfter(date)){
            if(listElementIndex < records.size() && records.get(listElementIndex).getDate().equals(date)){
                listElementIndex++;
            } else {
                missedRecords.add(new CurrencyRecord(records.get(listElementIndex - 1), date));
            }
        }
        records.addAll(missedRecords);
        records.sort(Comparator.comparingLong((CurrencyRecord r) -> r.getDate().getTime()));
    }

    public void trimRecordsToStartDate(Date startDate){
        records = records.stream()
                .filter((CurrencyRecord r) -> !r.getDate().before(startDate))
                .collect(Collectors.toList());
    }

    public void setRecordsDifferences(){
        recordsDifferences = new LinkedList<>();
        for(int i = 1; i < records.size(); i++){
            recordsDifferences.add(new CurrencyRecordDifferenceDto(records.get(i - 1), records.get(i)));
        }
    }

}

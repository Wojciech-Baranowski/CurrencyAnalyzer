package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.currencyRecord.CurrencyRecord;
import com.example.currencyanalyzerbackend.currencyRecordDifference.dto.CurrencyRecordDifferenceDto;
import com.example.currencyanalyzerbackend.data.RequestDataDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.currencyanalyzerbackend.data.DateService.dayAfter;

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
        LocalDate startDate = records.get(0).getDate();
        LocalDate endDate = fullRequestDataDto.getEndDate();
        List<CurrencyRecord> missedRecords = new LinkedList<>();
        int listElementIndex = 0;

        for(LocalDate date = startDate; date.isBefore(dayAfter(endDate)); date = dayAfter(date)){
            if(listElementIndex < records.size() && records.get(listElementIndex).getDate().equals(date)){
                listElementIndex++;
            } else {
                missedRecords.add(new CurrencyRecord(records.get(listElementIndex - 1), date));
            }
        }
        records.addAll(missedRecords);
        records.sort(Comparator.comparingLong((CurrencyRecord r) -> r.getDate().toEpochDay()));
    }

    public void trimRecordsToStartDate(LocalDate startDate){
        records = records.stream()
                .filter((CurrencyRecord r) -> !r.getDate().isBefore(startDate))
                .collect(Collectors.toList());
    }

    public void setRecordsDifferences(){
        recordsDifferences = new LinkedList<>();
        for(int i = 1; i < records.size(); i++){
            recordsDifferences.add(new CurrencyRecordDifferenceDto(records.get(i - 1), records.get(i)));
        }
    }

}

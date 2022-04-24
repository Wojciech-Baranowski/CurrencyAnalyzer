package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.currencyRecord.dtos.CurrencyRecordDto;
import com.example.currencyanalyzerbackend.currencyRecordDifference.dtos.CurrencyRecordDifferenceDto;
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

import static com.example.currencyanalyzerbackend.date.DateService.dayAfter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Currency {

    private String name;
    private String code;
    private List<CurrencyRecordDto> records;
    private List<CurrencyRecordDifferenceDto> recordsDifferences;

    void fillEmptyDays(RequestDataDto fullRequestDataDto) {
        LocalDate startDate = records.get(0).getDate();
        LocalDate endDate = fullRequestDataDto.getEndDate();
        List<CurrencyRecordDto> missedRecords = new LinkedList<>();
        int listElementIndex = 0;

        for(LocalDate date = startDate; date.isBefore(dayAfter(endDate)); date = dayAfter(date)){
            if(isDateMissing(listElementIndex, date)) {
                missedRecords.add(new CurrencyRecordDto(records.get(listElementIndex - 1), date));
            } else {
                listElementIndex++;
            }
        }
        records.addAll(missedRecords);
        records.sort(Comparator.comparingLong((CurrencyRecordDto r) -> r.getDate().toEpochDay()));
    }

    void trimRecordsToStartDate(LocalDate startDate) {
        records = records.stream()
                .filter((CurrencyRecordDto r) -> !r.getDate().isBefore(startDate))
                .collect(Collectors.toList());
    }

    void setRecordsDifferences() {
        recordsDifferences = new LinkedList<>();
        for(int i = 1; i < records.size(); i++) {
            recordsDifferences.add(new CurrencyRecordDifferenceDto(records.get(i - 1), records.get(i)));
        }
    }

    private boolean isDateMissing(int listElementIndex, LocalDate date) {
        return !(listElementIndex < records.size() && records.get(listElementIndex).getDate().equals(date));
    }
}

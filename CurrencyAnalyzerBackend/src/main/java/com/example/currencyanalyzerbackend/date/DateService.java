package com.example.currencyanalyzerbackend.date;

import java.time.LocalDate;

public class DateService {

    public static LocalDate dayAfter(LocalDate date){
        return date.plusDays(1);
    }

    public static LocalDate yearAfter(LocalDate date){
        return date.plusYears(1);
    }

    public static LocalDate yearAndDayAfter(LocalDate date){
        return date
                .plusYears(1)
                .plusDays(1);
    }

    public static LocalDate chooseEarlierDate(LocalDate date1, LocalDate date2){
        return date1.isBefore(date2) ? date1 : date2;
    }
}

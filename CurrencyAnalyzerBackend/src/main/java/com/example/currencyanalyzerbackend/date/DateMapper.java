package com.example.currencyanalyzerbackend.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMapper {

    private static final String DAY_FIRST_DATE_PATTERN = "dd-MM-yyyy";
    private static final String DAY_LAST_DATE_PATTERN = "yyyy-MM-dd";
    private static final SimpleDateFormat dayFirstDateFormat = new SimpleDateFormat(DAY_FIRST_DATE_PATTERN);
    private static final SimpleDateFormat dayLastDateFormat = new SimpleDateFormat(DAY_LAST_DATE_PATTERN);

    public static String dateToStringDayFirst(Date date){
        return dayFirstDateFormat.format(date);
    }

    public static String dateToStringDayLast(Date date){
        return dayLastDateFormat.format(date);
    }

    public static Date stringToDateDayFirst(String string){
        try {
            return dayFirstDateFormat.parse(string);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Date stringToDateDayLast(String string){
        try {
            return dayLastDateFormat.parse(string);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}

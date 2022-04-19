package com.example.currencyanalyzerbackend.date;

import java.util.Date;

public class DateService {

    public static final long YEAR_IN_MILLISECONDS = 31556952000L;
    public static final long DAY_IN_MILLISECONDS = 86400000L;

    public static final long WEEK_IN_MILLISECONDS = 604800000L;

    public static final long TIME_IN_MILLISECONDS_FROM_EPOCH_TO_2005 = 1104526800000L;

    public static boolean areDatesOverYearApart(Date date1, Date date2){
        return Math.abs(date1.getTime() - date2.getTime()) > YEAR_IN_MILLISECONDS;
    }

    public static Date dayAfter(Date date){
        return new Date(date.getTime() + DAY_IN_MILLISECONDS);
    }

    public static Date yearAfter(Date date){
        return new Date(date.getTime() + YEAR_IN_MILLISECONDS);
    }

    public static Date yearAndDayAfter(Date date){
        return  new Date(date.getTime() + YEAR_IN_MILLISECONDS + DAY_IN_MILLISECONDS);
    }

    public static Date weekBefore(Date date){
        return  new Date(date.getTime() - WEEK_IN_MILLISECONDS);
    }

    public static Date chooseEarlierDate(Date date1, Date date2){
        return date1.before(date2) ? date1 : date2;
    }

}

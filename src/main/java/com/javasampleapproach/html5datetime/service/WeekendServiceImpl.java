package com.javasampleapproach.html5datetime.service;

import com.google.gson.Gson;
import com.javasampleapproach.html5datetime.model.Forma;
import com.javasampleapproach.html5datetime.model.LogTime;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class WeekendServiceImpl implements WeekendService  {

   public int countWeekend(LogTime logTime) {
       LocalDate startDate = logTime.getStartTime();
       LocalDate endDate = logTime.getEndTime();
        int weekdays = 0;

        if (startDate.isEqual(endDate)) {
            weekdays = 0;

        }
        while(startDate.isBefore(endDate)) {
            if (DayOfWeek.SATURDAY.equals(startDate.getDayOfWeek())
                    || DayOfWeek.SUNDAY.equals(startDate.getDayOfWeek())) {
                weekdays++;
            }
            startDate = startDate.plusDays(1);
        }
        return weekdays;

    }

    public int result(String start, String end){
       LogTime logTime = new LogTime();

    LocalDate strDate = logTime.getStartTime();
    LocalDate endDate = logTime.getEndTime();
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
     start = strDate.format(formatter);
     LocalDate parsedDate = LocalDate.parse(start, formatter);

     end = endDate.format(formatter);
     LocalDate parsedDate2 = LocalDate.parse(end, formatter);

    logTime.setStartTime(parsedDate);
    logTime.setEndTime(parsedDate2);
    return countWeekend(logTime);
}

    @Override
    public Forma parse(Forma json) throws IOException {
        Gson gson = new Gson();
        Forma product = gson.fromJson(String.valueOf(json), Forma.class);

        return product;

    }

}

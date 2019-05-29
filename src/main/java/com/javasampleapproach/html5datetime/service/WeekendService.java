package com.javasampleapproach.html5datetime.service;

import com.javasampleapproach.html5datetime.model.Forma;
import com.javasampleapproach.html5datetime.model.LogTime;

import java.io.IOException;
import java.util.List;

public interface WeekendService {

    int countWeekend(LogTime logTime);

    public int result(String start1, String end1);

   Forma parse(Forma json) throws IOException;
}

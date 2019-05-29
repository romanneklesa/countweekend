package com.javasampleapproach.html5datetime.model;

import com.google.gson.annotations.SerializedName;

public class Forma {

    @SerializedName("startTime")
   private String start;

    @SerializedName("endTime")
    private String end;


    public Forma(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public Forma() {
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

}

package com.javasampleapproach.html5datetime.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class LogTime {

	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate startTime;

	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private LocalDate endTime ;;


	public LogTime(){}

	public LogTime( LocalDate startTime, LocalDate endTime){
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public void setStartTime(LocalDate startTime){
		this.startTime = startTime;
	}

	public LocalDate getStartTime(){
		return this.startTime;
	}
	
	public void setEndTime(LocalDate endTime){
		this.endTime = endTime;
	}

	public LocalDate getEndTime(){
		return this.endTime;
	}

}

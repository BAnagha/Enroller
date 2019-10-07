package com.enroller.ilstu.edu.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Shift {
	
	private Long shiftVenueId;
	private Long id;
	private String day;
	private String startTime;
	private String endTime;
	private int numberOfWorkers;
	private int numberOfMains;
	private Venue venue;
	
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	public Long getShiftVenueId() {
		return shiftVenueId;
	}
	public void setShiftVenueId(Long shiftVenueId) {
		this.shiftVenueId = shiftVenueId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
			this.startTime = startTime;
		
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		
			this.endTime = endTime;
	}
	public int getNumberOfWorkers() {
		return numberOfWorkers;
	}
	public void setNumberOfWorkers(int numberOfWorkers) {
		this.numberOfWorkers = numberOfWorkers;
	}
	public int getNumberOfMains() {
		return numberOfMains;
	}
	public void setNumberOfMains(int numberOfMains) {
		this.numberOfMains = numberOfMains;
	}
	public Shift(Long shiftVenueId, Long id, String day, String startTime, String endTime, int numberOfWorkers,
			int numberOfMains, Venue venue) {
		super();
		this.shiftVenueId = shiftVenueId;
		this.id = id;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.numberOfWorkers = numberOfWorkers;
		this.numberOfMains = numberOfMains;
		this.venue = venue;
	}
	public Shift() {
		super();
	}
	@Override
	public String toString() {
		return "Shift [shiftVenueId=" + shiftVenueId + ", id=" + id + ", day=" + day + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", numberOfWorkers=" + numberOfWorkers + ", numberOfMains=" + numberOfMains
				+ ", venue=" + venue + "]";
	}
	
	
}

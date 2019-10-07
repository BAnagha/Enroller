package com.enroller.ilstu.edu.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeShiftDetails {
	private Long shiftId;
	private Long shiftVenueId;
	private String startTime;
	private String endTime;
	private String shiftVenueName;
	private String shiftVenueAddress;
	private String shiftDay;
	private Long empId;
	private boolean isSubletted;
	
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public boolean getIsSubletted() {
		return isSubletted;
	}
	public void setIsSubletted(boolean isSubletted) {
		this.isSubletted = isSubletted;
	}
	public String getShiftDay() {
		return shiftDay;
	}
	public void setShiftDay(String shiftDay) {
		this.shiftDay = shiftDay;
	}
	public String getShiftVenueName() {
		return shiftVenueName;
	}
	public void setShiftVenueName(String shiftVenueName) {
		this.shiftVenueName = shiftVenueName;
	}
	public String getShiftVenueAddress() {
		return shiftVenueAddress;
	}
	public void setShiftVenueAddress(String shiftVenueAddress) {
		this.shiftVenueAddress = shiftVenueAddress;
	}
	public Long getShiftId() {
		return shiftId;
	}
	public void setShiftId(Long shiftId) {
		this.shiftId = shiftId;
	}
	public Long getShiftVenueId() {
		return shiftVenueId;
	}
	public void setShiftVenueId(Long shiftVenueId) {
		this.shiftVenueId = shiftVenueId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String string) {
		this.startTime = string;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		
			this.endTime = endTime;
	}
	
		
	@Override
	public String toString() {
		return "EmployeeShiftDetails [shiftId=" + shiftId + ", shiftVenueId=" + shiftVenueId + ", startTime="
				+ startTime + ", endTime=" + endTime + ", shiftVenueName=" + shiftVenueName + ", shiftVenueAddress="
				+ shiftVenueAddress + ", shiftDay=" + shiftDay + ", empId=" + empId + ", isSubletted=" + isSubletted
				+ "]";
	}
	public EmployeeShiftDetails(Long shiftId, Long shiftVenueId, String startTime, String endTime, String shiftVenueName,
			String shiftVenueAddress, String shiftDay, Long empId, boolean isSubletted) {
		super();
		this.shiftId = shiftId;
		this.shiftVenueId = shiftVenueId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.shiftVenueName = shiftVenueName;
		this.shiftVenueAddress = shiftVenueAddress;
		this.shiftDay = shiftDay;
		this.empId = empId;
		this.isSubletted = isSubletted;
	}
	public EmployeeShiftDetails() {
		super();
	}

}

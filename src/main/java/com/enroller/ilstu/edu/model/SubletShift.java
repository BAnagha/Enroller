package com.enroller.ilstu.edu.model;

import java.util.Date;

public class SubletShift {
	
	private Long id;
	private Long empId;
	private Long shiftId;
	private Date dateOfSublet;
	private Shift employeeShiftId;
	private boolean isSubletted;
	
	public SubletShift(Long id, Long empId, Long shiftId, Date dateOfSublet, Shift employeeShiftId, Shift shift, boolean isSubletted) {
		super();
		this.id = id;
		this.empId = empId;
		this.shiftId = shiftId;
		this.dateOfSublet = dateOfSublet;
		this.employeeShiftId = employeeShiftId;
		this.shift = shift;
		this.isSubletted = isSubletted;
	}
	public boolean isSubletted() {
		return isSubletted;
	}
	public void setSubletted(boolean isSubletted) {
		this.isSubletted = isSubletted;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public SubletShift() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public Long getShiftId() {
		return shiftId;
	}
	public void setShiftId(Long shiftId) {
		this.shiftId = shiftId;
	}
	public Date getDateOfSublet() {
		return dateOfSublet;
	}
	public void setDateOfSublet(Date dateOfSublet) {
		this.dateOfSublet = dateOfSublet;
	}
	public Shift getEmployeeShiftId() {
		return employeeShiftId;
	}
	public void setEmployeeShiftId(Shift employeeShiftId) {
		this.employeeShiftId = employeeShiftId;
	}
	public Shift getShift() {
		return shift;
	}
	public void setShift(Shift shift) {
		this.shift = shift;
	}
	private Shift shift;

}

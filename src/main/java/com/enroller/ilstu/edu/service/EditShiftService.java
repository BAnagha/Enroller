package com.enroller.ilstu.edu.service;

import java.util.List;

import com.enroller.ilstu.edu.model.Shift;

public interface EditShiftService {

	List<Shift> getAllShifts();

	Shift getShift(String v_code);
	
	String editShift(Shift shift);
}

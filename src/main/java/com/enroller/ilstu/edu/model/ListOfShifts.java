/**
 * 
 */
package com.enroller.ilstu.edu.model;

import java.util.List;

/**
 * @author ANAGHA
 *
 */
public class ListOfShifts {
	
	private List<Shift> shifts;

	public List<Shift> getShifts() {
		return shifts;
	}

	public void setShifts(List<Shift> shifts) {
		this.shifts = shifts;
	}

	public ListOfShifts(List<Shift> shifts) {
		super();
		this.shifts = shifts;
	}
	
}

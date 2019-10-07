/**
 * 
 */
package com.enroller.ilstu.edu.service;

import java.util.Date;
import java.util.List;

import com.enroller.ilstu.edu.model.Shift;
import com.enroller.ilstu.edu.model.SubletShift;

/**
 * @author ANAGHA
 *
 */
public interface AddShiftService {
	
	List<Shift> getAvailableShifts();
	String takeUpShift(Long shift_id,Long emp_id);
	
	List<SubletShift> getSublettedShifts();
	
	String takeUpSublettedShift(Long shiftId,Long emp_id, Date dateOfSublet,Long subletId);

}

/**
 * 
 */
package com.enroller.ilstu.edu.service;

import java.util.Date;

/**
 * @author ANAGHA
 *
 */
public interface EmployeeSubletShiftService {
	
	String employeeSubletShift(Long shiftId, Long empId, Date dateOfSublet);

}

/**
 * 
 */
package com.enroller.ilstu.edu.service;

import java.util.List;

import com.enroller.ilstu.edu.model.Employee;
import com.enroller.ilstu.edu.model.EmployeeShiftDetails;

/**
 * @author akbhide
 *
 */
public interface EmployeeDetailsService {
	
	Employee getEmployeeDetails(String username);

	List<EmployeeShiftDetails> getShiftDetails(Long empId);
	
	Employee getEmployeeDetailsById(Long id);

}

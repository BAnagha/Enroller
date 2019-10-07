/**
 * 
 */
package com.enroller.ilstu.edu.service;

import java.util.Date;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.enroller.ilstu.edu.dao.EmployeeSubletShiftDAO;

/**
 * @author ANAGHA
 *
 */
@ManagedBean
public class EmployeeSubletShiftServiceImpl implements EmployeeSubletShiftService{

	@Autowired
	EmployeeSubletShiftDAO employeeSubletShiftDAO;
	
	@Override
	public String employeeSubletShift(Long shiftId, Long empId, Date dateOfSublet) {
		// TODO Auto-generated method stub
		return employeeSubletShiftDAO.employeeSubletShift(shiftId,empId, dateOfSublet);
	}

}

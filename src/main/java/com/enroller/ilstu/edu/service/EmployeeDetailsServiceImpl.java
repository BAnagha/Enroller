/*
* Enroller
*
* File name: WorkerAuthenticationServiceImpl.java
*
* Programmer: Anagha Bhide
*
* Date: Apr 28, 2019
*
*/
package com.enroller.ilstu.edu.service;

import java.util.List;

import javax.annotation.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.enroller.ilstu.edu.dao.EmployeeDetailsDAO;
import com.enroller.ilstu.edu.model.Employee;
import com.enroller.ilstu.edu.model.EmployeeShiftDetails;

/**
 * @author akbhide
 *
 */
@ManagedBean
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService{
	@Autowired
	EmployeeDetailsDAO employeedetailsDAO;
	
	@Override
	public Employee getEmployeeDetails(String username) {

		return employeedetailsDAO.getEmployeeDetails(username);
	}

	@Override
	public Employee getEmployeeDetailsById(Long id) {

		return employeedetailsDAO.getEmployeeDetailsById(id);
	}

	@Override
	public List<EmployeeShiftDetails> getShiftDetails(Long empId) {
		return employeedetailsDAO.getShiftDetails(empId);
	}

	

}

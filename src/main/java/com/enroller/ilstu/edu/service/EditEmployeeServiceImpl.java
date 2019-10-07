/**
 * 
 */
package com.enroller.ilstu.edu.service;


import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.enroller.ilstu.edu.dao.AddEmployeeDAO;
import com.enroller.ilstu.edu.dao.EditEmployeeDAO;
import com.enroller.ilstu.edu.model.Employee;
import com.enroller.ilstu.edu.model.WorkerAuthentication;

/**
 * @author akbhide
 *
 */
@ManagedBean
public class EditEmployeeServiceImpl implements EditEmployeeService{
	
	@Autowired
	EditEmployeeDAO editEmployeeDAO;

	@Override
	public String editEmployee(Employee employee, WorkerAuthentication workerAuthentication) {
		// TODO Auto-generated method stub
		return editEmployeeDAO.editEmployee(employee,workerAuthentication);
	}

	
}

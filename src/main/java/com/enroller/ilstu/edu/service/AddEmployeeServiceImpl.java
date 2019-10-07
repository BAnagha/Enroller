/**
 * 
 */
package com.enroller.ilstu.edu.service;


import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.enroller.ilstu.edu.dao.AddEmployeeDAO;
import com.enroller.ilstu.edu.model.Employee;
import com.enroller.ilstu.edu.model.WorkerAuthentication;

/**
 * @author akbhide
 *
 */
@ManagedBean
public class AddEmployeeServiceImpl implements AddEmployeeService{
	
	@Autowired
	AddEmployeeDAO addEmployeeDAO;

	@Override
	public String createEmployee(Employee employee, WorkerAuthentication workerAuthentication) {
		// TODO Auto-generated method stub
		return addEmployeeDAO.createEmployee(employee, workerAuthentication);
	}

}

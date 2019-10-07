/**
 * 
 */
package com.enroller.ilstu.edu.service;

import com.enroller.ilstu.edu.model.Employee;
import com.enroller.ilstu.edu.model.WorkerAuthentication;

/**
 * @author akbhide
 *
 */
public interface AddEmployeeService {
	
	String createEmployee(Employee employee, WorkerAuthentication workerAuthentication);

}

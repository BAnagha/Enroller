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
public interface EditEmployeeService {
	
	String editEmployee(Employee employee, WorkerAuthentication workerAuthentication);

}

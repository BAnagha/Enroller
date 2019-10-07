/**
 * 
 */
package com.enroller.ilstu.edu.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author ANAGHA
 *
 */
public class EmployeeMapper {
	
	public static Employee convertToEmployee(EmployeeObject empObj, Employee emp) {
		emp.setAddress(empObj.getAddress());
		try {
			emp.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(empObj.getDateOfBirth()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			emp.setDateOfjoining(new SimpleDateFormat("yyyy-MM-dd").parse(empObj.getDateOfJoining()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		emp.setEmail(empObj.getEmail());
		emp.setFirstName(empObj.getFirstName());
		emp.setGender(empObj.getGender());
		emp.setLastName(empObj.getLastname());
		emp.setPhoneNumber(empObj.getPhoneNumber());
		emp.setSalary(empObj.getSalary());
		return emp;
		
	}
	
	public static EmployeeObject convertToEmployeeObject(EmployeeObject emp, Employee empObj) {
		emp.setAddress(empObj.getAddress());
		emp.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").format(empObj.getDateOfBirth()));
		emp.setDateOfJoining(new SimpleDateFormat("yyyy-MM-dd").format(empObj.getDateOfjoining()));
		emp.setEmail(empObj.getEmail());
		emp.setFirstName(empObj.getFirstName());
		emp.setGender(empObj.getGender());
		emp.setLastname(empObj.getLastName());
		emp.setPhoneNumber(empObj.getPhoneNumber());
		emp.setSalary(empObj.getSalary());
		return emp;
		
	}

}

/**
 * 
 */
package com.enroller.ilstu.edu.model;

import java.util.Date;

/**
 * @author ANAGHA
 *
 */
public class Employee {
	
	private Long empId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private Date dateOfjoining;
	private String email;
	private String address;
	private Long phoneNumber;
	private String gender;
	private String role;
	private int salary;
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getDateOfjoining() {
		return dateOfjoining;
	}
	public void setDateOfjoining(Date dateOfjoining) {
		this.dateOfjoining = dateOfjoining;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Employee(Long empId, String firstName, String lastName, Date dateOfBirth, Date dateOfjoining, String email,
			String address, Long phoneNumber, String gender, String role, int salary) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.dateOfjoining = dateOfjoining;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.role = role;
		this.salary = salary;
	}
	public Employee() {
		super();
	}
	
	
	

}

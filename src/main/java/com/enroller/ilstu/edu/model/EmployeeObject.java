/**
 * 
 */
package com.enroller.ilstu.edu.model;

import java.util.Date;

/**
 * @author ANAGHA
 *
 */
public class EmployeeObject {
	
	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	private String lastname;
	private String dateOfBirth;
	private String address;
	private String email;
	private String password;
	private Long phoneNumber;
	private String dateOfJoining;
	private int salary;
	private String username;
	private String gender;
	
	
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public EmployeeObject(String firstName, String lastname, String dateOfBirth, String address, String email,
			String password, Long phoneNumber, String dateOfJoining, int salary) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.dateOfJoining = dateOfJoining;
		this.salary = salary;
	}
	private Employee employee;
	private EmployeeShiftDetails employeeShiftDetails;
	private Shift shift;
	private Venue venue;
	private WorkerAuthentication workerAuthentication;
	
	public EmployeeObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeObject(Employee employee, EmployeeShiftDetails employeeShiftDetails, Shift shift, Venue venue,
			WorkerAuthentication workerAuthentication) {
		super();
		this.employee = employee;
		this.employeeShiftDetails = employeeShiftDetails;
		this.shift = shift;
		this.venue = venue;
		this.workerAuthentication = workerAuthentication;
	}
	
	@Override
	public String toString() {
		return "EmployeeObject [firstName=" + firstName + ", lastname=" + lastname + ", dateOfBirth=" + dateOfBirth
				+ ", address=" + address + ", email=" + email + ", password=" + password + ", phoneNumber="
				+ phoneNumber + ", dateOfJoining=" + dateOfJoining + ", salary=" + salary + ", username=" + username
				+ ", gender=" + gender + ", employee=" + employee + ", employeeShiftDetails=" + employeeShiftDetails
				+ ", shift=" + shift + ", venue=" + venue + ", workerAuthentication=" + workerAuthentication + "]";
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public EmployeeShiftDetails getEmployeeShiftDetails() {
		return employeeShiftDetails;
	}
	public void setEmployeeShiftDetails(EmployeeShiftDetails employeeShiftDetails) {
		this.employeeShiftDetails = employeeShiftDetails;
	}
	public Shift getShift() {
		return shift;
	}
	public void setShift(Shift shift) {
		this.shift = shift;
	}
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	public WorkerAuthentication getWorkerAuthentication() {
		return workerAuthentication;
	}
	public void setWorkerAuthentication(WorkerAuthentication workerAuthentication) {
		this.workerAuthentication = workerAuthentication;
	}
}

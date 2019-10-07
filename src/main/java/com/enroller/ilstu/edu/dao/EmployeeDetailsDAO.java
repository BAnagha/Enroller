package com.enroller.ilstu.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;

import com.enroller.ilstu.edu.model.Employee;
import com.enroller.ilstu.edu.model.EmployeeShiftDetails;
import com.enroller.ilstu.edu.util.MYDb;


/**
 * @author akbhide
 *
 */
@ManagedBean
public class EmployeeDetailsDAO {
	
	public Employee getEmployeeDetails(String username) {
		Employee employee = new Employee();
		
		Connection con = MYDb.getCon();
		String result="";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("select * from employee where email = ?  ");
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				result = "success";
				employee.setEmpId(Long.parseLong(rs.getString("eid")));
				employee.setEmail(rs.getString("email"));
				employee.setAddress(rs.getString("address"));
				employee.setGender(rs.getString("gender"));
				employee.setDateOfBirth(rs.getDate("dob"));
				employee.setDateOfjoining(rs.getDate("doj"));
				employee.setFirstName(rs.getString("fname"));
				employee.setLastName(rs.getString("lname"));
				employee.setPhoneNumber(rs.getLong("phone"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return employee;
		
	}
	
	
	public Employee getEmployeeDetailsById(Long id) {
		Employee employee = new Employee();
		
		Connection con = MYDb.getCon();
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("select * from employee where eid = ?  ");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				employee.setEmpId(Long.parseLong(rs.getString("eid")));
				employee.setEmail(rs.getString("email"));
				employee.setAddress(rs.getString("address"));
				employee.setGender(rs.getString("gender"));
				employee.setDateOfBirth(rs.getDate("dob"));
				employee.setDateOfjoining(rs.getDate("doj"));
				employee.setFirstName(rs.getString("fname"));
				employee.setLastName(rs.getString("lname"));
				employee.setPhoneNumber(rs.getLong("phone"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return employee;
		
	}
	
	

	public List<EmployeeShiftDetails> getShiftDetails(Long empId) {
		List<EmployeeShiftDetails> employeeShiftDetailsList = new ArrayList<EmployeeShiftDetails>();
		Connection con = MYDb.getCon();
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("select s.*,v.*,es.emp_id,es.is_subletted from employee_shift es, shifts s, venue v where s.id= es.shift_id and v.id= s.shift_venue_id and es.emp_id = ? ");
			stmt.setLong(1, empId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				EmployeeShiftDetails employeeShiftDetails = new EmployeeShiftDetails();

				employeeShiftDetails.setShiftId(rs.getLong("id"));
				employeeShiftDetails.setShiftVenueId(rs.getLong("shift_venue_id"));
				System.out.println(rs.getTime("start_time"));
				SimpleDateFormat formater = new SimpleDateFormat("HH:mm");
//				System.out.println("formatted :: "+formater.format(new java.util.Date(rs.getTime("start_time").getTime())));
				try {
//					System.out.println("parsed :: "+formater.parse(formater.format(new java.util.Date(rs.getTime("start_time").getTime()))));
					employeeShiftDetails.setStartTime(formater.format(formater.parse(rs.getTime("start_time").toString())));
					employeeShiftDetails.setEndTime(formater.format(formater.parse(rs.getTime("end_time").toString())));

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(employeeShiftDetails.getStartTime());
				employeeShiftDetails.setShiftVenueAddress(rs.getString("v_address"));
				employeeShiftDetails.setShiftVenueName(rs.getString("v_name"));
				employeeShiftDetails.setShiftDay(rs.getString("day"));
				employeeShiftDetails.setEmpId(rs.getLong("emp_id"));
				employeeShiftDetails.setIsSubletted(rs.getBoolean("is_subletted"));
				
				employeeShiftDetailsList.add(employeeShiftDetails);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return employeeShiftDetailsList;
		
	}
}

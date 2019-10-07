/**
 * 
 */
package com.enroller.ilstu.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.ManagedBean;

import com.enroller.ilstu.edu.model.Employee;
import com.enroller.ilstu.edu.model.WorkerAuthentication;
import com.enroller.ilstu.edu.util.MYDb;

/**
 * @author ANAGHA
 *
 */
@ManagedBean
public class AddEmployeeDAO {
	
	public String createEmployee(Employee employee, WorkerAuthentication workerAuthentication) {
		
		Connection con = MYDb.getCon();
		String result="";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("insert into employee(fname,lname,dob,gender,doj,address,phone,email,hourly_wage) values(?,?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, employee.getFirstName());
			stmt.setString(2, employee.getLastName());
			stmt.setDate(3, new java.sql.Date(employee.getDateOfBirth().getTime()));
			stmt.setString(4, employee.getGender());
			stmt.setDate(5,new java.sql.Date(employee.getDateOfjoining().getTime()));
			stmt.setString(6, employee.getAddress());
			stmt.setLong(7, employee.getPhoneNumber());
			stmt.setString(8, employee.getEmail());
			stmt.setInt(9, employee.getSalary());
			int rowCount = stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			while (rs.next()) {
				result = "success";
				stmt = (PreparedStatement) con.prepareStatement("insert into admin(emp_id,username,password,role) values(?,?,?,?)",
						Statement.RETURN_GENERATED_KEYS);
				stmt.setLong(1,rs.getLong(1));
				stmt.setString(2, workerAuthentication.getUsername());
				stmt.setString(3, workerAuthentication.getPassword());
				stmt.setString(4, workerAuthentication.getRole());
				rowCount = stmt.executeUpdate();
				if(rowCount>0) {
					result = "success";
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}

}

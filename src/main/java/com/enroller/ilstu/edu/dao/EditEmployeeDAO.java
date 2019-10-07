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
public class EditEmployeeDAO {

	public String editEmployee(Employee employee, WorkerAuthentication workerAuthentication) {

		Connection con = MYDb.getCon();
		String result="";
		try {
			PreparedStatement st = (PreparedStatement) con.prepareStatement("select * from admin where username = ?");
			st.setString(1, workerAuthentication.getUsername());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				int empid = rs.getInt("emp_id");
				PreparedStatement stmt = (PreparedStatement) con.prepareStatement("update employee set fname=?,lname=?,dob=?,gender=?,doj=?,address=?,phone=?,email=?,hourly_wage=? where eid = ?");
				stmt.setString(1, employee.getFirstName());
				stmt.setString(2, employee.getLastName());
				stmt.setDate(3, new java.sql.Date(employee.getDateOfBirth().getTime()));
				stmt.setString(4, employee.getGender());
				stmt.setDate(5,new java.sql.Date(employee.getDateOfjoining().getTime()));
				stmt.setString(6, employee.getAddress());
				stmt.setLong(7, employee.getPhoneNumber());
				stmt.setString(8, employee.getEmail());
				stmt.setInt(9, employee.getSalary());
				stmt.setInt(10, empid);
				int rowCount = stmt.executeUpdate();
				if(rowCount > 0) {
					result = "success";
					stmt = (PreparedStatement) con.prepareStatement("update admin set username=?,password=? values(?,?)");
					stmt.setString(1, workerAuthentication.getUsername());
					stmt.setString(2, workerAuthentication.getPassword());
					rowCount = stmt.executeUpdate();
					if(rowCount>0) {
						result = "success";
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

}

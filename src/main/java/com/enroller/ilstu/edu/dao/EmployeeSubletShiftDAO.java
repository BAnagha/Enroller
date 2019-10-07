package com.enroller.ilstu.edu.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.ManagedBean;

import com.enroller.ilstu.edu.util.MYDb;

@ManagedBean
public class EmployeeSubletShiftDAO {
	
	public String employeeSubletShift(Long shiftId, Long empId, Date dateOfSublet) {
		Connection con = MYDb.getCon();
		String result="";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("insert into sublets(shift_id,emp_id, date_of_sublet) values(?,?,?)");
			stmt.setLong(1, shiftId);
			stmt.setLong(2, empId);
			stmt.setDate(3, new java.sql.Date(dateOfSublet.getTime()));
			int rowCount = stmt.executeUpdate();
			if (rowCount > 0) {
				stmt = (PreparedStatement) con.prepareStatement("update employee_shift set is_subletted = 1 where shift_id = ? and emp_id = ?");
				stmt.setLong(1, shiftId);
				stmt.setLong(2, empId);
				rowCount = stmt.executeUpdate();
				if(rowCount > 0)
				{
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

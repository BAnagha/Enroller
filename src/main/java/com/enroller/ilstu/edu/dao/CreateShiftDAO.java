/**
 * 
 */
package com.enroller.ilstu.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.ManagedBean;

import com.enroller.ilstu.edu.model.Shift;
import com.enroller.ilstu.edu.util.MYDb;

/**
 * @author ANAGHA
 *
 */
@ManagedBean
public class CreateShiftDAO {
	
public String createShift(Shift shift) {
		
		Connection con = MYDb.getCon();
		String result="";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("insert into shifts(shift_venue_id,day,start_time,end_time,available_positions,total_positions) values(?,?,?,?,?,?)");
			stmt.setLong(1, shift.getShiftVenueId());
			stmt.setString(2, shift.getDay());
			stmt.setTime(3, new java.sql.Time(Long.parseLong(shift.getStartTime())));
			stmt.setTime(4, new java.sql.Time(Long.parseLong(shift.getEndTime())));
			stmt.setInt(5, shift.getNumberOfWorkers());
			stmt.setInt(6,shift.getNumberOfWorkers());
			
			int rowCount = stmt.executeUpdate();		
			if (rowCount > 0) {
				result = "success";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}


}

package com.enroller.ilstu.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.ManagedBean;

import com.enroller.ilstu.edu.model.Venue;
import com.enroller.ilstu.edu.util.MYDb;

@ManagedBean
public class AddShiftVenueDAO {

public String addShiftVenue(Venue venue) {
		
		Connection con = MYDb.getCon();
		String result="";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("insert into venue(v_code,v_name,v_address) values(?,?,?)");
			stmt.setString(1, venue.getVenueCode());
			stmt.setString(2, venue.getVenueName());
			stmt.setString(3, venue.getVenueAddress());
			
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

/**
 * 
 */
package com.enroller.ilstu.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import com.enroller.ilstu.edu.model.Employee;
import com.enroller.ilstu.edu.model.Venue;
import com.enroller.ilstu.edu.model.WorkerAuthentication;
import com.enroller.ilstu.edu.util.MYDb;

/**
 * @author ANAGHA
 *
 */
@ManagedBean
public class EditVenueDAO {
	
	public String editVenue(Venue venue) {

		Connection con = MYDb.getCon();
		String result="";
		try {
				PreparedStatement stmt = (PreparedStatement) con.prepareStatement("update venue set v_name =?,v_address=? where v_code = ?");
				stmt.setString(3,venue.getVenueCode());
				stmt.setString(1, venue.getVenueName());
				stmt.setString(2,venue.getVenueAddress());
				
				int rowCount = stmt.executeUpdate();
				if(rowCount > 0) {
					result = "success";
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

	public Venue getVenue(String vCode) {
		Venue venue = new Venue();
		Connection con = MYDb.getCon();
		try {
				
				PreparedStatement stmt = (PreparedStatement) con.prepareStatement("select * from venue where v_code = ?");
				stmt.setString(1,vCode);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					venue.setId(rs.getLong("id"));
					venue.setVenueAddress(rs.getString("v_address"));
					venue.setVenueName(rs.getString("v_name"));
					venue.setVenueCode(rs.getString("v_code"));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return venue;
	}
	
	public List<Venue>getAllVenues() {
		List<Venue> venueList = new ArrayList<Venue>();
		Connection con = MYDb.getCon();
		try {
				
				PreparedStatement stmt = (PreparedStatement) con.prepareStatement("select * from venue");
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					Venue venue = new Venue();
					venue.setId(rs.getLong("id"));
					venue.setVenueAddress(rs.getString("v_address"));
					venue.setVenueName(rs.getString("v_name"));
					venue.setVenueCode(rs.getString("v_code"));
					venueList.add(venue);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return venueList;
	}
}

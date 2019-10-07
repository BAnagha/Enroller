/**
 * 
 */
package com.enroller.ilstu.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import com.enroller.ilstu.edu.model.Shift;
import com.enroller.ilstu.edu.model.Venue;
import com.enroller.ilstu.edu.util.MYDb;

/**
 * @author ANAGHA
 *
 */
@ManagedBean
public class EditShiftDAO {

	public List<Shift> getAllShifts(){
		List<Shift> shiftList = new ArrayList<Shift>();
		Connection con = MYDb.getCon();
		try {

			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("select s.id as sid,s.shift_venue_id,s.day, s.start_time,s.end_time,s.available_positions, s.total_positions,  v.id as vid, v.v_code, v.v_address, v.v_name from shifts s, venue v where s.shift_venue_id = v.id");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Venue venue = new Venue();
				Shift shift = new Shift();

				shift.setId(rs.getLong("sid"));
				shift.setShiftVenueId(rs.getLong("shift_venue_id"));
				shift.setDay(rs.getString("day"));
				SimpleDateFormat formater = new SimpleDateFormat("HH:mm");
				try {
					shift.setStartTime(formater.format(formater.parse(rs.getTime("start_time").toString())));
					shift.setEndTime(formater.format(formater.parse(rs.getTime("end_time").toString())));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				shift.setNumberOfWorkers(rs.getInt("available_positions"));
				shift.setNumberOfMains(rs.getInt("total_positions"));

				venue.setId(rs.getLong("vid"));
				venue.setVenueAddress(rs.getString("v_address"));
				venue.setVenueName(rs.getString("v_name"));
				venue.setVenueCode(rs.getString("v_code"));
				shift.setVenue(venue);

				shiftList.add(shift);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return shiftList;
	}

	public String editShift(Shift shift) {
		Connection con = MYDb.getCon();
		String result ="";
		try {

			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("update shifts set day =?, start_time = ?, end_time = ?,available_positions =?, total_positions = ?  where id =?");
			stmt.setString(1,shift.getDay());
//			stmt.setTime(2,new java.sql.Time(Long.parseLong(shift.getStartTime())));
			stmt.setTime(3, new java.sql.Time(Long.parseLong(shift.getEndTime())));
			stmt.setInt(4, shift.getNumberOfWorkers());
			stmt.setInt(5, shift.getNumberOfMains());
			stmt.setLong(6, shift.getId());
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
	//	public Shift getShift(String v_code) {
	//		Connection con = MYDb.getCon();
	//		try {
	//				
	//				PreparedStatement stmt = (PreparedStatement) con.prepareStatement("select s.id as sid,s.shift_venue_id,s.day, s.start_time,s.end_time,s.available positions, s.total_positions,  v.id as vid, v.v_code, v.v_address, v.v_name from shifts s, venue v where s.shift_venue_id = v.id and v_vode =?");
	//				stmt.setString(1,v_code);
	//				ResultSet rs = stmt.executeQuery();
	//				while(rs.next()) {
	//					Venue venue = new Venue();
	//					Shift shift = new Shift();
	//					
	//					shift.setId(rs.getLong("sid"));
	//					shift.setShiftVenueId(rs.getLong("shift_venue_id"));
	//					shift.setDay(rs.getString("day"));
	//					shift.setStartTime(new java.util.Date(rs.getDate("start_time").getTime()));
	//					shift.setEndTime(new java.util.Date(rs.getDate("end_time").getTime()));
	//					shift.setNumberOfWorkers(rs.getInt("available_positions"));
	//					shift.setNumberOfMains(rs.getInt("total_positions"));
	//					
	//					venue.setId(rs.getLong("vid"));
	//					venue.setVenueAddress(rs.getString("v_address"));
	//					venue.setVenueName(rs.getString("v_name"));
	//					venue.setVenueCode(rs.getString("v_code"));
	//					shift.setVenue(venue);
	//					
	//					shiftList.add(shift);
	//				}
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//
	//		return shiftList;
	//	}


}

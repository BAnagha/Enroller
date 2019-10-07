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

import com.enroller.ilstu.edu.model.Shift;
import com.enroller.ilstu.edu.model.SubletShift;
import com.enroller.ilstu.edu.model.Venue;
import com.enroller.ilstu.edu.util.MYDb;


/**
 * @author akbhide
 *
 */
@ManagedBean
public class AddShiftDAO {

	public List<Shift> getAvailableShifts() {
		List<Shift> shiftList = new ArrayList<Shift>();
		Connection con = MYDb.getCon();
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("select s.*,v.* from shifts s, venue v where v.id= s.shift_venue_id and s.available_positions > 0 ");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Shift shift = new Shift();
				shift.setId(rs.getLong("id"));
				shift.setShiftVenueId(rs.getLong("shift_venue_id"));
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
				shift.setDay(rs.getString("day"));
				Venue venue = new Venue();
				venue.setVenueAddress(rs.getString("v_address"));
				venue.setVenueCode(rs.getString("v_code"));
				venue.setVenueName(rs.getString("v_name"));
				shift.setVenue(venue);
				
				System.out.println("shift "+ shift);
				shiftList.add(shift);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return shiftList;
		
	}
	
	
	public String takeUpShift(Long shift_id,Long emp_id) {

		Connection con = MYDb.getCon();
		String result="";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("insert into employee_shift(shift_id,emp_id) values(?,?)");
			stmt.setLong(1, shift_id);
			stmt.setLong(2, emp_id);
			int rowCount = stmt.executeUpdate();
			if (rowCount > 0) {
				result = "success";
				stmt = (PreparedStatement) con.prepareStatement("update shifts set available_positions = available_positions -1 where available_positions > 0 and id =?");
				stmt.setLong(1, shift_id);
				rowCount = stmt.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


	public List<SubletShift> getSublettedShifts() {
		List<SubletShift> subletShiftList = new ArrayList<SubletShift>();
		Connection con = MYDb.getCon();
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("select s.*,v.*, sb.id sbId, sb.shift_id sbShiftId, sb.emp_id sbEmpId, sb.date_of_sublet, es.is_subletted from shifts s, venue v, sublets sb, employee_shift es where v.id= s.shift_venue_id and sb.shift_id = s.id and es.shift_id = sb.shift_id and es.is_subletted = 1 and sb.taken = 0 ");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Shift shift = new Shift();
				shift.setId(rs.getLong("id"));
				shift.setShiftVenueId(rs.getLong("shift_venue_id"));
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
				shift.setDay(rs.getString("day"));
				Venue venue = new Venue();
				venue.setVenueAddress(rs.getString("v_address"));
				venue.setVenueCode(rs.getString("v_code"));
				venue.setVenueName(rs.getString("v_name"));
				shift.setVenue(venue);
				
				SubletShift subletShift = new SubletShift();
				subletShift.setShift(shift);
				System.out.println(rs.getString("date_of_sublet"));
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date convertedDate = new java.util.Date(rs.getDate("date_of_sublet").getTime());
					System.out.println("Converted date :: "+ convertedDate);
					subletShift.setDateOfSublet(formatter.parse(formatter.format(convertedDate)));
					System.out.println("set date == "+ subletShift.getDateOfSublet());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				subletShift.setEmpId(rs.getLong("sbEmpId"));
				subletShift.setSubletted(rs.getBoolean("is_subletted"));
				subletShift.setId(rs.getLong("sbId"));
				subletShift.setShiftId(rs.getLong("sbShiftId"));
				
				
				System.out.println("subletShift ==  "+ subletShift);
				subletShiftList.add(subletShift);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return subletShiftList;
	}
	
	
	public String takeUpSublettedShift(Long shift_id,Long emp_id, Date dateOfSublet, Long subletId) {

		Connection con = MYDb.getCon();
		String result="";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("insert into employee_subletted_shifts(shift_id,emp_id, date_of_sublet, sublet_id) values(?,?,?,?)");
			stmt.setLong(1, shift_id);
			stmt.setLong(2, emp_id);
			stmt.setDate(3, new java.sql.Date(dateOfSublet.getTime()));
			stmt.setLong(4, subletId);
			int rowCount = stmt.executeUpdate();
			if (rowCount > 0) {
				stmt = (PreparedStatement) con.prepareStatement("update sublets set taken = 1 where shift_id = ? and emp_id = ?  and id = ?  ");
				stmt.setLong(1, shift_id);
				stmt.setLong(2, emp_id);
				stmt.setLong(3, subletId);
				rowCount = stmt.executeUpdate();
				if(rowCount > 0)
				{
					result = "Success";
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}

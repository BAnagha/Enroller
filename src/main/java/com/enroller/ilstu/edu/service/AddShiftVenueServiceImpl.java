/**
 * 
 */
package com.enroller.ilstu.edu.service;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.enroller.ilstu.edu.dao.AddShiftVenueDAO;
import com.enroller.ilstu.edu.model.Venue;

/**
 * @author ANAGHA
 *
 */
@ManagedBean
public class AddShiftVenueServiceImpl implements AddShiftVenueService{
	
	@Autowired
	AddShiftVenueDAO addShiftVenueDAO;
	
	@Override
	public String addShiftVenue(Venue venue) {
		// TODO Auto-generated method stub
		return addShiftVenueDAO.addShiftVenue(venue);
	}

}

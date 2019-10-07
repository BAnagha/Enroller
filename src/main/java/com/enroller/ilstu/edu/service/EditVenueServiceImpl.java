/**
 * 
 */
package com.enroller.ilstu.edu.service;

import java.util.List;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.enroller.ilstu.edu.dao.EditVenueDAO;
import com.enroller.ilstu.edu.model.Venue;

/**
 * @author ANAGHA
 *
 */
@ManagedBean
public class EditVenueServiceImpl implements EditVenueService{

	@Autowired
	EditVenueDAO editVenueDAO;
	
	@Override
	public List<Venue> getAllVenues() {
		// TODO Auto-generated method stub
		return editVenueDAO.getAllVenues();
	}

	@Override
	public String editVenue(Venue venue) {
		// TODO Auto-generated method stub
		return editVenueDAO.editVenue(venue);
	}

	@Override
	public Venue getVenue(String vCode) {
		// TODO Auto-generated method stub
		return editVenueDAO.getVenue(vCode);
	}
}

/**
 * 
 */
package com.enroller.ilstu.edu.service;

import java.util.List;

import com.enroller.ilstu.edu.model.Venue;

/**
 * @author ANAGHA
 *
 */
public interface EditVenueService {

	List<Venue> getAllVenues();

	String editVenue(Venue venue);

	Venue getVenue(String vCode);
}

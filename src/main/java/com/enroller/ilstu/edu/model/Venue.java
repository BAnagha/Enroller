/**
 * 
 */
package com.enroller.ilstu.edu.model;

/**
 * @author ANAGHA
 *
 */
public class Venue {
	private Long id;
	private String venueCode;
	private String venueAddress;
	private String venueName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Venue [id=" + id + ", venueCode=" + venueCode + ", venueAddress=" + venueAddress + ", venueName="
				+ venueName + "]";
	}
	public String getVenueCode() {
		return venueCode;
	}
	public void setVenueCode(String venueCode) {
		this.venueCode = venueCode;
	}
	public String getVenueAddress() {
		return venueAddress;
	}
	public void setVenueAddress(String venueAddress) {
		this.venueAddress = venueAddress;
	}
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public Venue(Long id, String venueCode, String venueAddress, String venueName) {
		super();
		this.id = id;
		this.venueCode = venueCode;
		this.venueAddress = venueAddress;
		this.venueName = venueName;
	}
	public Venue() {
		super();
	}

}

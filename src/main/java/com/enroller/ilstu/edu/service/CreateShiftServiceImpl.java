/**
 * 
 */
package com.enroller.ilstu.edu.service;


import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.enroller.ilstu.edu.dao.CreateShiftDAO;
import com.enroller.ilstu.edu.model.Shift;

/**
 * @author akbhide
 *
 */
@ManagedBean
public class CreateShiftServiceImpl implements CreateShiftService{

	@Autowired
	CreateShiftDAO createShiftDAO;
	
	@Override
	public String createShift(Shift shift) {
		// TODO Auto-generated method stub
		return createShiftDAO.createShift(shift);
	}
	

}

/*
* Enroller
*
* File name: WorkerAuthenticationServiceImpl.java
*
* Programmer: Anagha Bhide
*
* Date: Apr 28, 2019
*
*/
package com.enroller.ilstu.edu.service;

import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.enroller.ilstu.edu.dao.AddShiftDAO;
import com.enroller.ilstu.edu.model.Shift;
import com.enroller.ilstu.edu.model.SubletShift;

/**
 * @author akbhide
 *
 */
@ManagedBean
public class AddShiftServiceImpl implements AddShiftService{
	
	@Autowired
	AddShiftDAO addShiftDAO;

	@Override
	public List<Shift> getAvailableShifts() {
		// TODO Auto-generated method stub
		return addShiftDAO.getAvailableShifts();
	}

	@Override
	public String takeUpShift(Long shift_id, Long emp_id) {
		// TODO Auto-generated method stub
		return addShiftDAO.takeUpShift(shift_id, emp_id);
	}

	@Override
	public List<SubletShift> getSublettedShifts() {
		// TODO Auto-generated method stub
		return addShiftDAO.getSublettedShifts();
	}

	@Override
	public String takeUpSublettedShift(Long shiftId, Long emp_id, Date dateOfSublet, Long subletId) {
		// TODO Auto-generated method stub
		return addShiftDAO.takeUpSublettedShift(shiftId, emp_id, dateOfSublet, subletId);
	}



}

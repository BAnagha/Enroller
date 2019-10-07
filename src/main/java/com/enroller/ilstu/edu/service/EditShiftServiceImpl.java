/**
 * 
 */
package com.enroller.ilstu.edu.service;

import java.util.List;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.enroller.ilstu.edu.dao.EditShiftDAO;
import com.enroller.ilstu.edu.model.Shift;

/**
 * @author ANAGHA
 *
 */
@ManagedBean
public class EditShiftServiceImpl implements EditShiftService{

	@Autowired
	EditShiftDAO editShiftDAO;
	
	@Override
	public List<Shift> getAllShifts() {
		// TODO Auto-generated method stub
		return editShiftDAO.getAllShifts();
	}

	@Override
	public Shift getShift(String v_code) {
		// TODO Auto-generated method stub
		return null;//editShiftDAO.getShift();
	}

	@Override
	public String editShift(Shift shift) {
		// TODO Auto-generated method stub
		return editShiftDAO.editShift(shift);
	}

}

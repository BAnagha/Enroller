/*
 * Enroller
 *
 * File name: EditVenueController.java
 *
 * Programmer: Anagha Bhide
 *
 * Date: Apr 28, 2019
 *
 */
package com.enroller.ilstu.edu.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.enroller.ilstu.edu.model.Employee;
import com.enroller.ilstu.edu.model.Shift;
import com.enroller.ilstu.edu.service.EditShiftService;
import com.enroller.ilstu.edu.service.EditVenueService;
import com.enroller.ilstu.edu.service.EmployeeDetailsService;


/**
 * @author akbhide
 *
 */
@RestController
public class EditShiftController {

	@Autowired
	EmployeeDetailsService employeeDetailsService;

	@Autowired
	EditVenueService editVenueService;
	
	@Autowired
	EditShiftService editShiftService;

	@RequestMapping(value="/getEditShiftPage", method= {RequestMethod.GET})
	public ModelAndView getEditShiftPage()
	{
		ModelAndView mv = new ModelAndView();
		List<Shift> shifts = editShiftService.getAllShifts();
		mv.addObject("shifts", shifts);
		mv.setViewName("editShift");
		return mv;

	}

	@RequestMapping(value="/searchShift", method= {RequestMethod.POST})
	public ModelAndView searchShift(String v_code, HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		Shift shift = editShiftService.getShift(v_code);
		//System.out.println(venue);
//		if(venue.getId() != 0) {
//			mv.addObject("venue", venue);
//		}
//		else
//		{
//			mv.addObject("errMsg","Employee does not exist");
//		}
		mv.setViewName("editVenue");
		return mv;
	}


	@RequestMapping(value="/editShift", method= {RequestMethod.POST})
	public ModelAndView editShift(String shiftID, String day, String startTime, String endTime, String availablePositions, String totalPositions , HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		System.out.println(shiftID + " " +day+ " " + startTime+ " " + endTime+ " " + availablePositions + " " + totalPositions);
		Shift shift = new Shift();
		shift.setId(Long.parseLong(shiftID));
		shift.setDay(day);
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");

		try {
			shift.setStartTime(formatter.format(formatter.parse(startTime)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			shift.setEndTime(formatter.format(formatter.parse(endTime)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		shift.setNumberOfWorkers(Integer.parseInt(availablePositions));
		shift.setNumberOfMains(Integer.parseInt(totalPositions));
		String result =editShiftService.editShift(shift);
		Long id = Long.parseLong(request.getSession().getAttribute("adminId").toString());
		Employee employee = employeeDetailsService.getEmployeeDetailsById(id);
		if(result.equals("success"))
		{
			if(employee.getEmpId() !=0)
			{
				mv.addObject("admin",employee);
			}			
			mv.addObject("successMsg", "Employee created successfully");
		}
		else {
			mv.addObject("errMsg", "Something went wrong");
		}
		mv.setViewName("adminPage");
		return mv;
	}

}

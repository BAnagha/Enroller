/*
 * Enroller
 *
 * File name: AddShiftVenueController.java
 *
 * Programmer: Anagha Bhide
 *
 * Date: Apr 28, 2019
 *
 */
package com.enroller.ilstu.edu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.enroller.ilstu.edu.model.Employee;
import com.enroller.ilstu.edu.model.Venue;
import com.enroller.ilstu.edu.service.AddShiftVenueService;
import com.enroller.ilstu.edu.service.EmployeeDetailsService;

/**
 * @author akbhide
 *
 */
@RestController
public class AddShiftVenueController {
	
	@Autowired
	AddShiftVenueService addShiftVenueService;
	
	@Autowired
	EmployeeDetailsService employeeDetailsService;
	
	@RequestMapping(value="/getAddShiftVenuePage", method= {RequestMethod.GET})
	public ModelAndView getAddShiftVenuePage()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addVenue");
 		return mv;
		
	}
	
	@RequestMapping(value="/addShiftVenue", method= {RequestMethod.POST})
	public ModelAndView addShiftVenue(String venueCode, String venueName, String venueAddress, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Venue venue = new Venue();
		venue.setVenueCode(venueCode);
		venue.setVenueAddress(venueAddress);
		venue.setVenueName(venueName);
		String result = addShiftVenueService.addShiftVenue(venue);
		Long id = Long.parseLong(request.getSession().getAttribute("adminId").toString());
		Employee emp = employeeDetailsService.getEmployeeDetailsById(id);
		if(result.equals("success"))
		{
			if(emp.getEmpId() !=0)
			{
				mv.addObject("admin",emp);
			}
			
			mv.setViewName("adminPage");
			mv.addObject("successMsg", "Employee created successfully");
			return mv;
			}
		else {
			mv.setViewName("adminPage");
			mv.addObject("errMsg", "Something went wrong");
			return mv;
		}
	}

}

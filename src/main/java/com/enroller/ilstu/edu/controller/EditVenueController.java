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

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.enroller.ilstu.edu.model.Employee;
import com.enroller.ilstu.edu.model.Venue;
import com.enroller.ilstu.edu.service.EditVenueService;
import com.enroller.ilstu.edu.service.EmployeeDetailsService;


/**
 * @author akbhide
 *
 */
@RestController
public class EditVenueController {

	@Autowired
	EmployeeDetailsService employeeDetailsService;

	@Autowired
	EditVenueService editVenueService;

	@RequestMapping(value="/getEditShiftVenuePage", method= {RequestMethod.GET})
	public ModelAndView getEditVenuePage()
	{
		ModelAndView mv = new ModelAndView();
		//call all venues and display
		List<Venue> venues = editVenueService.getAllVenues();
		mv.addObject("venues", venues);
		mv.setViewName("editVenue");
		return mv;

	}

	@RequestMapping(value="/searchVenue", method= {RequestMethod.POST})
	public ModelAndView searchVenue(String v_code, HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		Venue venue = new Venue();
		venue = editVenueService.getVenue(v_code);
		System.out.println(venue);
		if(venue.getId() != 0) {
			mv.addObject("venue", venue);
		}
		else
		{
			mv.addObject("errMsg","Employee does not exist");
		}
		mv.setViewName("editVenue");
		return mv;
	}


	@RequestMapping(value="/editVenue", method= {RequestMethod.POST})
	public ModelAndView editVenue(Venue venue, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		String result =editVenueService.editVenue(venue);
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

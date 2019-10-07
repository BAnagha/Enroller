/*
* Enroller
*
* File name: CreateShiftController.java
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
import com.enroller.ilstu.edu.model.Venue;
import com.enroller.ilstu.edu.service.CreateShiftService;
import com.enroller.ilstu.edu.service.EditVenueService;
import com.enroller.ilstu.edu.service.EmployeeDetailsService;


/**
 * @author akbhide
 *
 */
@RestController
public class CreateShiftController {
	
	@Autowired
	CreateShiftService createShiftService;
	
	@Autowired
	EmployeeDetailsService employeeDetailsService;
	
	@Autowired
	EditVenueService editVenueService;
	
	@RequestMapping(value="/getCreateShiftPage", method= {RequestMethod.GET})
	public ModelAndView getCreateShiftPage()
	{
		ModelAndView mv = new ModelAndView();
		List<Venue> venues = editVenueService.getAllVenues();
		mv.addObject("venues", venues);
		mv.setViewName("createShift");
 		return mv;
		
	}
	
	@RequestMapping(value="/createShift", method= {RequestMethod.POST})
	public ModelAndView createShift(String venueCode,String venueId, String day, String startTime, String endTime, String numberOfWorkers , HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Shift shift = new Shift();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		try {
			shift.setStartTime(formatter.format(formatter.parse(startTime)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		shift.setDay(day);
		shift.setNumberOfWorkers(Integer.parseInt(numberOfWorkers));
		try {
			shift.setEndTime(formatter.format(formatter.parse(endTime)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		shift.setShiftVenueId(Long.parseLong(venueId));
		
		
		System.out.println("start time "+ shift.getStartTime());
		System.out.println("end time "+ shift.getEndTime());

		String result = createShiftService.createShift(shift);
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

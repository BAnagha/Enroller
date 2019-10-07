/*
 * Enroller
 *
 * File name: AddShiftController.java
 *
 * Programmer: Anagha Bhide
 *
 * Date: Apr 28, 2019
 *
 */
package com.enroller.ilstu.edu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.enroller.ilstu.edu.model.ListOfShifts;
import com.enroller.ilstu.edu.model.Shift;
import com.enroller.ilstu.edu.service.AddShiftService;

/**
 * @author akbhide
 *
 */
@RestController
public class AddShiftController {
	
	@Autowired
	AddShiftService addShiftService;
	
	@RequestMapping(value="/addShift", method= {RequestMethod.GET})
	public ModelAndView addShift(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		List<Shift> shiftList = new ArrayList<Shift>();
		shiftList = addShiftService.getAvailableShifts();
		ListOfShifts listOfShifts = new ListOfShifts(shiftList);
			if(shiftList.size() != 0)
			{
				mv.addObject("shifts",listOfShifts);
				mv.setViewName("addShift");
				return mv;
			}
			else {
				mv.setViewName("employeeDetails");
				mv.addObject("errMsg", "Something went wrong...");
				return mv;
			}
	}
	
	@RequestMapping(value="/addShiftToSchedule", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView addShiftToSchedule(Long shiftId, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Long employeeID = Long.parseLong(request.getSession().getAttribute("empId").toString());
		String result = addShiftService.takeUpShift(shiftId, employeeID);
//		
			if(result.equals("success"))
			{
				mv.setViewName("redirect:/getDetails");
				return mv;
			}
			else {
				mv.setViewName("redirect:/getDetails");
				mv.addObject("errMsg", "Something went wrong...");
				return mv;
			}
	}
}

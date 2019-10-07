/*
 * Enroller
 *
 * File name: AddSublettedShiftController.java
 *
 * Programmer: Anagha Bhide
 *
 * Date: Apr 28, 2019
 *
 */
package com.enroller.ilstu.edu.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.enroller.ilstu.edu.model.SubletShift;
import com.enroller.ilstu.edu.service.AddShiftService;

/**
 * @author akbhide
 *
 */
@RestController
public class AddSublettedShiftController {
	
	@Autowired
	AddShiftService addShiftService;
	
	@RequestMapping(value="/addSublettedShift", method= {RequestMethod.GET})
	public ModelAndView addShift(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		List<SubletShift> sublettedShiftList = new ArrayList<SubletShift>();
		sublettedShiftList = addShiftService.getSublettedShifts();
		for(int i = 0; i< sublettedShiftList.size() ; i++) {
			System.out.println(sublettedShiftList.get(i));
		}
//		ListOfShifts listOfShifts = new ListOfShifts(shiftList);
			if(sublettedShiftList.size() != 0)
			{
				System.out.println("Inside if");
				mv.addObject("sublettedShiftList",sublettedShiftList);
				mv.setViewName("addSublettedShift");
				return mv;
			}
			else {
				mv.setViewName("employeeDetails");
				mv.addObject("errMsg", "Something went wrong...");
				return mv;
			}
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/addSublettedShiftToSchedule", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView addSublettedShiftToSchedule(Long shiftId, Long empId, Long subletId,String dateOfSublet, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Long employeeID = Long.parseLong(request.getSession().getAttribute("empId").toString());
		Date subletDate = null;
		System.out.println("dateOfSublet "+ dateOfSublet + " shiftId " + shiftId + " empId "+empId + " subletId " );
		subletDate = new Date(dateOfSublet);
		String result = addShiftService.takeUpSublettedShift(shiftId, empId, subletDate, subletId);
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

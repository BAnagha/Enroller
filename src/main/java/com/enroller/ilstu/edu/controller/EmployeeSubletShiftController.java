/**
 * 
 */
package com.enroller.ilstu.edu.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.enroller.ilstu.edu.model.EmployeeShiftDetails;
import com.enroller.ilstu.edu.service.EmployeeDetailsService;
import com.enroller.ilstu.edu.service.EmployeeSubletShiftService;

/**
 * @author ANAGHA
 *
 */
@RestController
public class EmployeeSubletShiftController {
	
	@Autowired
	EmployeeDetailsService employeeDetailsService;
	
	@Autowired
	EmployeeSubletShiftService employeeSubletShiftService;
	
	@RequestMapping(value="/getSubletShiftPage", method= {RequestMethod.GET})
	public ModelAndView getSubletShiftPage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Long empId = Long.parseLong(request.getSession().getAttribute("empId").toString()); 
		 List<EmployeeShiftDetails> empShiftDetails = employeeDetailsService.getShiftDetails(empId);
			System.out.println("Inside getSubletShiftPage "+ empShiftDetails);

			if(empShiftDetails.size() != 0)
			{
				System.out.println("Inside getSubletShiftPage");
				mv.addObject("empShiftDetails",empShiftDetails);
				mv.setViewName("employeeSublet");
				return mv;
			}
			else {
				mv.setViewName("employeeDetails");
				mv.addObject("errMsg", "Something went wrong...");
				return mv;
			}
	}
	
	@RequestMapping(value="/employeeSubletShift", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView employeeSubletShift(Long shiftId,String dateOfSublet, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		System.out.println("date is "+ dateOfSublet);
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfSublet);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			date = new Date(dateOfSublet);
			e.printStackTrace();
		}
		Long empId = Long.parseLong(request.getSession().getAttribute("empId").toString());
		String result = employeeSubletShiftService.employeeSubletShift(shiftId, empId, date);
//		
			if(result.equals("success"))
			{
				mv.setViewName("redirect:/getDetails");
				return mv;
			}
			else {
				mv.setViewName("redirect:/getSubletShiftPage");
				mv.addObject("errMsg", "Something went wrong...");
				return mv;
			}
	}
}

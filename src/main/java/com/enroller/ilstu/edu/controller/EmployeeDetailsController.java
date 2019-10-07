/*
* Enroller
*
* File name: EmployeeDetailsController.java
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
import com.enroller.ilstu.edu.model.EmployeeShiftDetails;
import com.enroller.ilstu.edu.service.EmployeeDetailsService;


/**
 * @author akbhide
 *
 */
@RestController
public class EmployeeDetailsController {
	
	@Autowired
	EmployeeDetailsService employeeDetailsService;
	
	@RequestMapping(value="/getDetails", method= {RequestMethod.GET})
	public ModelAndView getDetails(String username, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if(username == null)
		{
			username = request.getSession().getAttribute("username").toString();
		}
		Employee employee = employeeDetailsService.getEmployeeDetails(username);
		List<EmployeeShiftDetails> employeeShiftdetails = employeeDetailsService.getShiftDetails(employee.getEmpId());
		if(employee.getEmpId() !=0)
		{
			mv.setViewName("employeeDetails");
			mv.addObject("emp",employee);
			for(int i=0;i<employeeShiftdetails.size(); i++)
			{
				System.out.println(employeeShiftdetails.get(i));
			}
			if(employeeShiftdetails.size() > 0)
			{
				mv.addObject("empShiftDetails", employeeShiftdetails);
			}
			return mv;
		}
		else {
			mv.setViewName("index");
			mv.addObject("errMsg", "Incorrect username or password");
			return mv;
		}
	}

}

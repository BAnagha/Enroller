/*
 * Enroller
 *
 * File name: WorkerAuthenticationController.java
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
import com.enroller.ilstu.edu.model.WorkerAuthentication;
import com.enroller.ilstu.edu.service.EmployeeDetailsService;
import com.enroller.ilstu.edu.service.WorkerAuthenticationService;


/**
 * @author akbhide
 *
 */
@RestController
public class WorkerAuthenticationController {

	@Autowired
	WorkerAuthenticationService workerAuthenticationService;

	@Autowired
	EmployeeDetailsService employeeDetailsService;
	
	@RequestMapping(value="/authenticate", method= {RequestMethod.POST})
	public ModelAndView authenticateWorker(String username, String password, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		System.out.println(username + " === "+ password);
		WorkerAuthentication wa = workerAuthenticationService.authenticateWorker(username, password);
		System.out.println(wa);
		if(wa != null && wa.getEmpId() != null) {
			if(wa.getEmpId() != 0) {
				Employee employee = employeeDetailsService.getEmployeeDetailsById(wa.getEmpId());
				System.out.println(employee);
				if( wa.getRole().equals("WORKER"))
				{
					request.getSession().setAttribute("role", wa.getRole());
					List<EmployeeShiftDetails> employeeShiftdetails = employeeDetailsService.getShiftDetails(employee.getEmpId());
					for(int i=0 ; i<employeeShiftdetails.size() ; i++)
					{
						System.out.println(employeeShiftdetails.get(i));
					}
					request.getSession().setAttribute("username", username);
					if(employee.getEmpId() !=0)
					{
						mv.addObject("emp",employee);
						request.getSession().setAttribute("empId", employee.getEmpId());
						if(employeeShiftdetails.size() > 0)
						{
							mv.addObject("empShiftDetails", employeeShiftdetails);
						}
					}
					
					mv.setViewName("employeeDetails");
					mv.addObject("worker",wa);
					return mv;
				}else{
					request.getSession().setAttribute("role", wa.getRole());
					request.getSession().setAttribute("username", username);
					if(employee.getEmpId() !=0)
					{
						mv.addObject("admin",employee);
						request.getSession().setAttribute("adminId", employee.getEmpId());

					}
					
					mv.setViewName("adminPage");
					mv.addObject("worker",wa);
					return mv;
				}

			}
			else {
				mv.setViewName("index");
				mv.addObject("errMsg", "Incorrect username or password");
				return mv;
			}
		}
		else {
			mv.setViewName("index");
			mv.addObject("errMsg", "Incorrect username or password");
			return mv;
		}
	}
	
	@RequestMapping(value="/logout", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView logout(String username, String password, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		request.getSession().invalidate();
		mv.setViewName("index");
		return mv;
		
	}

}

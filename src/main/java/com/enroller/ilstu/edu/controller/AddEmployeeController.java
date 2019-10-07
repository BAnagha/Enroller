/*
* Enroller
*
* File name: AddEmployeeController.java
*
* Programmer: Anagha Bhide
*
* Date: Apr 28, 2019
*
*/
package com.enroller.ilstu.edu.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.enroller.ilstu.edu.model.Employee;
import com.enroller.ilstu.edu.model.WorkerAuthentication;
import com.enroller.ilstu.edu.service.AddEmployeeService;
import com.enroller.ilstu.edu.service.EmployeeDetailsService;
import com.enroller.ilstu.edu.service.WorkerAuthenticationService;


/**
 * @author akbhide
 *
 */
@RestController
public class AddEmployeeController {
	
	@Autowired
	EmployeeDetailsService employeeDetailsService;
	
	@Autowired
	AddEmployeeService addEmployeeService;
	
	@Autowired
	WorkerAuthenticationService workerAuthenticationService;
	
	@RequestMapping(value="/getAddEmployeePage", method= {RequestMethod.GET})
	public ModelAndView addEmployee()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addEmployee");
 		return mv;
		
	}
	
	
	@RequestMapping(value="/addEmployee", method= {RequestMethod.POST})
	public ModelAndView addEmployee(String firstName, String lastName,String address, String birthday, String email, String password,
			String phone, String doj, String salary, String gender, String username, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setAddress(address);
		try {
			employee.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		employee.setEmail(email);
		employee.setPhoneNumber(Long.parseLong(phone));
		try {
			employee.setDateOfjoining(new SimpleDateFormat("yyyy-MM-dd").parse(doj));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		employee.setGender(gender);
		employee.setSalary(Integer.parseInt(salary));
		
		WorkerAuthentication workerAuthentication = new WorkerAuthentication();
		workerAuthentication.setUsername(username);
		workerAuthentication.setPassword(password);
		workerAuthentication.setRole("WORKER");
		
		String result = addEmployeeService.createEmployee(employee, workerAuthentication);
		username = request.getSession().getAttribute("username").toString();
		Long id = Long.parseLong(request.getSession().getAttribute("adminId").toString());
		System.out.println("id is ==== "+id);
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

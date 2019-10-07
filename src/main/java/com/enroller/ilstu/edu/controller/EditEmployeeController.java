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

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.enroller.ilstu.edu.model.Employee;
import com.enroller.ilstu.edu.model.EmployeeMapper;
import com.enroller.ilstu.edu.model.EmployeeObject;
import com.enroller.ilstu.edu.model.WorkerAuthentication;
import com.enroller.ilstu.edu.service.EditEmployeeService;
import com.enroller.ilstu.edu.service.EmployeeDetailsService;
import com.enroller.ilstu.edu.service.WorkerAuthenticationService;


/**
 * @author akbhide
 *
 */
@RestController
public class EditEmployeeController {

	@Autowired
	EmployeeDetailsService employeeDetailsService;

	@Autowired
	EditEmployeeService editEmployeeService;

	@Autowired
	WorkerAuthenticationService workerAuthenticationService;

	@RequestMapping(value="/getEditEmployeePage", method= {RequestMethod.GET})
	public ModelAndView getEditEmployeePage()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editEmployee");
		return mv;

	}

	@RequestMapping(value="/searchEmployee", method= {RequestMethod.POST})
	public ModelAndView searchEmployee(String username, HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		WorkerAuthentication workerAuthentication = workerAuthenticationService.getAuthenticationByUsername(username);
		Employee employee = employeeDetailsService.getEmployeeDetails(username);
		EmployeeObject employeeObject = new EmployeeObject();
		employeeObject.setEmployee(employee);
		employeeObject.setWorkerAuthentication(workerAuthentication);

		employeeObject = EmployeeMapper.convertToEmployeeObject(employeeObject, employee);
		employeeObject.setUsername(workerAuthentication.getUsername());
		employeeObject.setPassword(workerAuthentication.getPassword());
		if(employee.getEmpId() != 0) {
			mv.addObject("emp", employeeObject);
		}
		else
		{
			mv.addObject("errMsg","Employee does not exist");
		}
		mv.setViewName("editEmployee");
		return mv;
	}


	@RequestMapping(value="/editEmployee", method= {RequestMethod.POST})
	public ModelAndView editEmployee(String firstName, String lastName,String address, String birthday, String email, String password,
			String phone, String doj, String salary, String gender, String username, EmployeeObject emp, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Employee employee = new Employee();
		EmployeeMapper.convertToEmployee(emp, employee);
		WorkerAuthentication workerAuthentication = new WorkerAuthentication();
		workerAuthentication.setUsername(emp.getUsername());
		workerAuthentication.setPassword(emp.getPassword());
		String result = editEmployeeService.editEmployee(employee, workerAuthentication);
		Long id = Long.parseLong(request.getSession().getAttribute("adminId").toString());
		employee = employeeDetailsService.getEmployeeDetailsById(id);
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

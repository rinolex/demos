package com.HRManagementSystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.HRManagementSystem.model.Employee;
import com.HRManagementSystem.service.EmployeeService;
import com.HRManagementSystem.service.UserServices;

/**
 * <p>
 * Application Controller that provides mapping between the GUI functionalities
 * and the Database queries.
 * </p>
 * 
 * @author Roman Nikolov
 *
 */
@Controller
public class ApplicationController {
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	UserServices userServices;
	
	/**
	 * Welcome page Model
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("employees", employeeService.showAllEmployees());
		request.setAttribute("mode", "ALL_EMPLOYEES");
		return "welcomepage";
	}
	
	/**
	 * Displays all employee entries
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("/showALLEmployees")
	public String showAllEmployees(HttpServletRequest request) {
		request.setAttribute("employees", employeeService.showAllEmployees());
		request.setAttribute("mode", "ALL_EMPLOYEES");
		return "welcomepage";
	}

	/**
	 * Adds single employee entry to the database
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addEmployee")
	public String addEmployee(HttpServletRequest request) {
		request.setAttribute("mode", "ADD_EMPLOYEE");
		return "welcomepage";
	}
	
	/**
	 * Persists employee entry into the database
	 * 
	 * @param employee
	 * @param bindingResult
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee employee, BindingResult bindingResult, 
								HttpServletRequest request) {
		if(employeeService.saveEmployee(employee)) {	
			request.setAttribute("employees", employeeService.showAllEmployees());
			request.setAttribute("mode", "ALL_EMPLOYEES");
			return "welcomepage";
		} else {
			request.setAttribute("error", "Employee With This Email Already Exists");
			request.setAttribute("mode", "ADD_EMPLOYEE");
			return "welcomepage";
		}
	}

	/**
	 * Edits single employee using its unique ID
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/editEmployee")
	public String editEmployee(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("employee", employeeService.editEmployee(id));
		request.setAttribute("mode", "ADD_EMPLOYEE");
		return "welcomepage";
	}


	/**
	 * Deletes single employee using its unique ID
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam int id, HttpServletRequest request) {
		employeeService.deleteEmployee(id);
		request.setAttribute("employees", employeeService.showAllEmployees());
		request.setAttribute("mode", "ALL_EMPLOYEES");
		return "welcomepage";
	}

	/**
	 * Lists the last two added entries
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("/showLatestEntries")
	public String showLatestEntries(HttpServletRequest request) {
		request.setAttribute("employees", employeeService.findLatest());
		request.setAttribute("mode", "ALL_EMPLOYEES");
		return "welcomepage";
	}

	/**
	 * Sorts employees in ASC order by their first name
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("/sortByNameASC")
	public String sortByNameASC(HttpServletRequest request) {
		request.setAttribute("employees", employeeService.sortByNameASC());
		request.setAttribute("mode", "ALL_EMPLOYEES");
		return "welcomepage";
	}

	/**
	 * Display details  for a single employee
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/employeeInfo")
	public String employeeInfo(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("employees", employeeService.employeeInfo(id));
		request.setAttribute("mode", "ALL_EMPLOYEES");
		return "welcomepage";
	}
}
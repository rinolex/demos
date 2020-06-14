package com.HRManagementSystem.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRManagementSystem.model.Employee;
import com.HRManagementSystem.repository.EmployeeRepository;

/**
 * Implementation of all service methods featured by the app.
 * 
 * @author Roman Nikolov
 *
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/**
	 * List all database entries
	 */
	public List<Employee> showAllEmployees(){
		List<Employee> employees = new ArrayList<Employee>();
		for(Employee Employee : employeeRepository.findAll()) {
			employees.add(Employee);
		}
		
		return employees;
	}
	
	/**
	 *  Adds employee to the database
	 *  
	 *  @param Populated Employee Object
	 */
	public void saveEmployee(Employee employee ) {
		System.out.println(employee);
		employeeRepository.save(employee);
	}
	
	/**
	 * Delete single employee
	 * 
	 * @param Delete By ID
	 */
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}
	
	/**
	 * Edit employee entry
	 * 
	 * @param Edit using record ID
	 */
	public Employee editEmployee(int id) {
		return employeeRepository.getOne(id);
	}
	
	/**
	 * List last two added employees to the database
	 */
	public List<Employee> findLatest() {
		return employeeRepository.findTop3ByOrderByIdDesc();
	}
	
	/**
	 * Sort employees in ASC order by first name
	 */
	public List<Employee> sortByNameASC(){
		return employeeRepository.findAllByOrderByFirstNameAsc();
	}
	
	/**
	 * Display/Get employee info
	 * 
	 * @param employee id
	 */
	public List<Employee> employeeInfo(int id) {
		List<Employee> employeeInfo = new ArrayList<>();
		employeeInfo.add(employeeRepository.getOne(id));
		return employeeInfo;
	}
}
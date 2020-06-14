package com.HRManagementSystem.service;

import java.util.List;

import com.HRManagementSystem.model.Employee;

/**
 * All business functionalities provided 
 * by the HR Management System.
 * 
 * @author Roman Nikolov
 *
 */
public interface EmployeeService {
 // These are all business service methods used by the app.
 List<Employee> showAllEmployees();
 void saveEmployee(Employee Employee);
 Employee editEmployee(int id);
 void deleteEmployee(int id);
 List<Employee> findLatest();
 List <Employee> sortByNameASC();
 List<Employee> employeeInfo(int id);
}
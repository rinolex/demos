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
 // Employee Services
 List<Employee> showAllEmployees();
 boolean saveEmployee(Employee Employee);
 Employee editEmployee(int id);
 void deleteEmployee(int id);
 List<Employee> findLatest();
 List <Employee> sortByNameASC();
 List<Employee> employeeInfo(int id);
}
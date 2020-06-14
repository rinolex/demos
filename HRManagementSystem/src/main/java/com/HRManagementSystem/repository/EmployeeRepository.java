package com.HRManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HRManagementSystem.model.Employee;

/**
 * Repository interface based on the Spring Date Hibernate implementation
 * 
 * @author Roman Nikolov
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// Named queries that could be used for fast fetching employees 
	// according to certain criteria
	List<Employee>findTopByOrderByIdDesc();
	List <Employee> findTop3ByOrderByIdDesc();
	List <Employee> findAllByOrderByFirstNameAsc();
}
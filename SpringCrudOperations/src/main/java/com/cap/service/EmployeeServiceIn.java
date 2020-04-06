package com.cap.service;

import java.util.List;
import java.util.Optional;

import com.cap.bean.Employee;

public interface EmployeeServiceIn {

	Optional<Employee> getEmployeeDetails(int id);

	Employee createEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	void deleteEmployee(int id);

	List<Employee> fetchAllEmployees();

}

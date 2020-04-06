package com.cap.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cap.bean.Employee;
import com.cap.dao.EmployeeDaoIn;

@Service
@Transactional
public class EmployeeService implements EmployeeServiceIn {

	@Autowired
	private EmployeeDaoIn dao;
	
	@Override
	public Optional<Employee> getEmployeeDetails(int id) {
		return dao.findById(id);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		boolean bool = dao.existsById(employee.getEid());
		if(bool == true) {
			dao.save(employee);
			return employee;
		}
		else {
			dao.save(employee);
			return employee;
		}
	}

	@Override
	public void deleteEmployee(int id) {
		dao.deleteById(id);
	}

	@Override
	public List<Employee> fetchAllEmployees() {
		return dao.findAll();
	}
}
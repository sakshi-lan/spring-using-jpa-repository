package com.cap.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cap.bean.Employee;
import com.cap.service.EmployeeServiceIn;

@RestController
@CrossOrigin("http://localhost:8080")
public class MyController {
	@Autowired
	private EmployeeServiceIn service;

	// fetch the particular employee
	@GetMapping("/getEmployeeDetails/{enter Employee id here}")
	public Optional<Employee> getEmployeeDetails(@PathVariable ("enter Employee id here") int id){
		return service.getEmployeeDetails(id);
	}

	//create the employee
	@PostMapping("/createEmployee")
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
		Employee emp = service.createEmployee(employee);
		if(emp == null) {
			ResponseEntity<String> responseEntity = new ResponseEntity<String>("Sorry, unable to insert the Employee",HttpStatus.OK);
			return responseEntity;
		}
		else {
			ResponseEntity<String> responseEntity = new ResponseEntity<String>("Employee was inserted successfully!!",HttpStatus.OK);
			return responseEntity;
		}
	}

	// update the employee
	@PutMapping("/updateEmployee")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		Employee emp = service.updateEmployee(employee);
		if(emp != null) {
			ResponseEntity<String> responseEntity = new ResponseEntity<String>("Employee details were updated successfully!!"+"\nEmployee ID : "+employee.getEid()+"\nEmployee Name : "
					+employee.getEname()+"\nEmployee Salary : "+employee.getEsal(),HttpStatus.OK);
			return responseEntity;
		}
		else {
			ResponseEntity<String> responseEntity = new ResponseEntity<String>("Sorry, employee details were not updated",HttpStatus.OK);
			return responseEntity;
		}
	}

	// delete the employee
	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable ("id") int id) {
		service.deleteEmployee(id);
	}

	// fetch all employees
	@GetMapping("/fetchAllEmployees")
	public List<Employee> fetchAllEmployees(){
		List<Employee>list = service.fetchAllEmployees();
		return list;
	}
}

package com.java.demo.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.demo.entity.Employee;
import com.java.demo.exception.ResourceNotFoundException;
import com.java.demo.service.IEmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmp(@Valid @RequestBody Employee emp){
		Employee saveEmployee = service.saveEmployee(emp);
		return new ResponseEntity<Employee>(saveEmployee,new HttpHeaders(),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllEmp")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> empList = service.getAllEmployee();
		return new ResponseEntity<List<Employee>>(empList,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable Long id) throws ResourceNotFoundException{
		Employee empById = service.getEmpById(id);
		return new ResponseEntity<Employee>(empById,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/get/degination/{degination}")
	public ResponseEntity<List<Employee>> getEmpByDegination(@PathVariable("degination")String degination)throws ResourceNotFoundException{
		List<Employee> empList = service.getByDegination(degination);
		return new ResponseEntity<List<Employee>>(empList,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id)throws ResourceNotFoundException{
		Map<String, Boolean> delete = service.delete(id);
		return new ResponseEntity<Map<String,Boolean>>(delete,new HttpHeaders(),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateAndSave(@Valid@RequestBody Employee emp,@PathVariable Long id) throws ResourceNotFoundException{
		Employee updateEmp = service.update(emp, id);
		return new ResponseEntity<Employee>(updateEmp,new HttpHeaders(),HttpStatus.OK);
	}

}

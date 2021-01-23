package com.java.demo.service;

import java.util.List;
import java.util.Map;

import com.java.demo.entity.Employee;
import com.java.demo.exception.ErrorDetails;
import com.java.demo.exception.ResourceNotFoundException;

public interface IEmployeeService {
	
	public Employee saveEmployee(Employee emp);
	
	public List<Employee> getAllEmployee();
	
	public List<Employee> getByDegination(String degination)throws ResourceNotFoundException;
	
	public Employee getEmpById(Long id)throws ResourceNotFoundException;
	
	//public ErrorDetails delete(Long id)throws ResourceNotFoundException;
	public  Map<String,Boolean> delete(Long id) throws ResourceNotFoundException;
	
	public Employee update(Employee emp,Long id) throws ResourceNotFoundException;

}

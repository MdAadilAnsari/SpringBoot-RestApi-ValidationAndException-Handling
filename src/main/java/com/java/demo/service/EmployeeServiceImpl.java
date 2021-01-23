package com.java.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.demo.entity.Employee;
import com.java.demo.exception.ErrorDetails;
import com.java.demo.exception.ResourceNotFoundException;
import com.java.demo.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepo repo;
	
	@Override
	public Employee saveEmployee(Employee emp) {
		Employee save = repo.save(emp);
		return save;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> empList = repo.findAll();
		if (!empList.isEmpty()) {
			return empList;
		} else {
			return new ArrayList<Employee>();
		}
	}

	@Override
	public Employee getEmpById(Long id) throws ResourceNotFoundException {
		Employee employee = repo.findById(id)
								.orElseThrow(() 
								-> new ResourceNotFoundException("Employee not found with this id:: "+id));
		 return employee;
		
	}

	@Override
	public Map<String, Boolean> delete(Long id) throws ResourceNotFoundException {
		Employee emp = repo.findById(id)
							 .orElseThrow(() 
							 -> new ResourceNotFoundException("Employee not found with this id "+id));
		 repo.delete(emp);
		 Map<String, Boolean> response = new HashMap<>();
		 response.put("Deleted", Boolean.TRUE);
		 return response;
	}

	@Override
	public Employee update(Employee emp, Long id) throws ResourceNotFoundException {
		Employee employee = repo.findById(id)
				                .orElseThrow(() 
				                -> new ResourceNotFoundException("Employee not found with this id "+id));
		employee.setEmpName(emp.getEmpName());
		employee.setSalary(emp.getSalary());
		employee.setDegination(emp.getDegination());
		employee.setEmailId(emp.getEmailId());
		employee.setMobileNumber(emp.getMobileNumber());
		final Employee updateEmployee = repo.save(employee);
		return updateEmployee;
	}

	@Override
	public List<Employee> getByDegination(String degination) throws ResourceNotFoundException {
		List<Employee> empList = repo.findByDegination(degination);
		if(empList.isEmpty()) {
			throw new ResourceNotFoundException("Employee not found with this degination "+degination);
		}
		return empList;
	}

}

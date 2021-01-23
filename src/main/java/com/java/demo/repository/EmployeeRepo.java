package com.java.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.demo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Serializable> {
	
	public List<Employee> findByDegination(String degination);

}

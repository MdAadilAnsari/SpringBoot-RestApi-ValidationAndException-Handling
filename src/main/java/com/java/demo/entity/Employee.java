package com.java.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPLOYEE_TAB")
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "EMP_NAME")
	@NotBlank(message = "Name should not blanlk")
	private String empName;
	
	@Column(name = "SALARY")
	private Double salary;
	
	@Column(name = "DEGINATION")
	@NotNull
	private String degination;
	
	@Column(name = "EMAIL_ID")
	@Email
	@NotBlank(message = "Please provide valid email_id!")
	private String emailId;
	
	@Column(name = "MOBILE_NUMBER")
	//@Size(min = 0,max = 10,message = "Mobile Number should contain 10 digits only!")
	//@NotBlank(message = "Please provide mobile number")
	private Long mobileNumber;

}

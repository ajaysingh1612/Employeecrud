package com.ajay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajay.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	

}

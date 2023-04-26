package com.ajay.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ajay.Model.Employee;
import com.ajay.repository.EmployeeRepository;

@RestController
@RequestMapping("/e")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	@PostMapping("/employee")
	public String createnewemployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return "Employee Record is inserted";
		
	}
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>>getAllEmployees(){
		List<Employee>empList=new ArrayList<>();
		employeeRepository.findAll().forEach(empList::add);
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
		
	}
	@PutMapping("/employee/{id}")
	public String updateEmployeeById(@PathVariable int id, @RequestBody Employee employee) {
		Optional<Employee>emp=employeeRepository.findById(id);
		if(emp.isPresent()) {
			Employee existEmp=emp.get();
			existEmp.setFname(employee.getFname());
			existEmp.setLname(employee.getLname());
		    existEmp.setAge(employee.getAge());
			existEmp.setCity(employee.getCity());
			employeeRepository.save(existEmp);
			return "Employee record is updated";
		}
		else
		{
			return "Employee Details does not exist for this empid";
			
		}
		
	}
	
@DeleteMapping("/employee")
public String deleteAllEmployee() {
	employeeRepository.deleteAll();
	return "All Employee Record is deleted";
}

}

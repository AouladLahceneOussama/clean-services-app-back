package com.example.demo.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Employees;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api")
public class EmployeesController {

	private final EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("employees/{phone}")
	public ResponseEntity<Employees> getEmployeesById(@PathVariable String phone) {
		return employeeService.getEmployeesById(phone);
	}

	@PostMapping("employees/add")
	public ResponseEntity<String> addEmployee(@Valid @RequestBody Employees e) {
		return employeeService.addEmployee(e);
	}

	@PostMapping("employees/login")
	public ResponseEntity<String> login(@RequestBody Employees e) {
		return employeeService.login(e);
	}

	@PutMapping("employees/{phone}/update")
	public ResponseEntity<Employees> updateEmployee(@PathVariable String phone,
			@RequestParam("full_name") String full_name,
			@RequestParam("mail") String mail,
			@RequestParam("description") String description) {
		return employeeService.updateEmployee(phone, full_name, mail, description);
	}

	// update image employee
	@PutMapping(value = "employees/{phone}/update/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Employees> updateEmployeeImage(@PathVariable String phone,
			@RequestParam("image") MultipartFile file) {
		return employeeService.updateEmployeeImage(phone, file);
	}

	@GetMapping("employees/online/map")
	public List<Employees> getLocationOnlineEmployees(){
		return employeeService.getLocationOnlineEmployees();
	}
}

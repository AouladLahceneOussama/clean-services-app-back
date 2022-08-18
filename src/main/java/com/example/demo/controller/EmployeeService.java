package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Employees;
import com.example.demo.model.Workflow;
import com.example.demo.repository.EmployeesRepository;
import com.example.demo.repository.WorkflowRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmployeeService {

    private final EmployeesRepository employeesRepository;
    private final WorkflowRepository workflowRepository;
    private static String imageDirectory = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";

    @Autowired
    public EmployeeService(EmployeesRepository employeesRepository, WorkflowRepository workflowRepository) {
        this.employeesRepository = employeesRepository;
        this.workflowRepository = workflowRepository;
    }

    // get employee by id
    public ResponseEntity<Employees> getEmployeesById(String phone) {
        Employees Employees = employeesRepository.getEmployeeByusername(phone);
        return ResponseEntity.ok(Employees);
    }

    // add employee to db
    public ResponseEntity<String> addEmployee(Employees e) {
        Optional<Employees> empOptional = employeesRepository.findById(e.getphone());
        if (!empOptional.isPresent()) {
            employeesRepository.save(e);

            String days[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday",
                    "Pause Time" };
            for (String day : days) {
                Workflow w = new Workflow(e, day);
                workflowRepository.save(w);
            }

            return ResponseEntity.ok("saved");
        } else {
            return ResponseEntity.ok("Duplicate id");
        }
    }

    public ResponseEntity<String> login(Employees e) {
        Optional<Employees> empOptional = employeesRepository.getEmployeeByusernameAndPass(e.getphone(),
                e.getPassword());

        if (!empOptional.isPresent())
            return ResponseEntity.ok("unlogged");

        Employees emp;
        emp = employeesRepository.getById(e.getphone());
        emp.setLatitude(e.getLatitude());
        emp.setLongitude(e.getLongitude());
        employeesRepository.save(emp);
        return ResponseEntity.ok("logged");
    }

    public ResponseEntity<Employees> updateEmployee(String phone,
            String full_name,
            String mail,
            String description) {

        Employees employee = employeesRepository.findById(phone).orElseThrow();
        employee.setFull_name(full_name);
        employee.setMail(mail);
        employee.setDescription(description);

        Employees updatedEmployee = employeesRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // method to create the upload image folder if doesnt exist
    private void makeDirectoryIfNotExist(String imageDirectory) {
        File directory = new File(imageDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    public ResponseEntity<Employees> updateEmployeeImage(String phone,
            MultipartFile file) {

        Employees employee = employeesRepository.findById(phone).orElseThrow();

        // image traitement
        // 1- extract extention
        int index = file.getOriginalFilename().lastIndexOf('.');
        String ext = file.getOriginalFilename().substring(index + 1);

        // 2- create unique name
        int randomNumber = (int) Math.floor(Math.random() * 1000);
        String newImageName = java.util.Calendar.getInstance().getTime().getTime() + "-" + randomNumber + "." + ext;

        // 3- store name to data base and store file in right folder
        makeDirectoryIfNotExist(imageDirectory);
        Path fileNamePath = Paths.get(imageDirectory, newImageName);
        employee.setImage(newImageName);

        try {
            Files.write(fileNamePath, file.getBytes());
            employeesRepository.save(employee);
            return ResponseEntity.ok(employee);
        } catch (IOException ex) {
            System.out.println(">>>>>>>>>>>>>> image error :  " + ex);
            return ResponseEntity.ok(employee);
        }
    }

    public Optional<Employees> getEmployeeById(String id_emp) {
        return employeesRepository.findById(id_emp);
    }

    public List<Employees> getLocationOnlineEmployees() {
        return employeesRepository.getLocationOnlineEmployees();
    }


}

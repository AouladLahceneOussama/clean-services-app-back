package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.example.demo.model.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, String> {

     @Query(value = "SELECT * FROM employees WHERE phone = ?1 ", nativeQuery = true)
     Employees getEmployeeByusername(String phone);

     @Query(value = "SELECT * FROM employees WHERE phone = ?1 and password = ?2 ", nativeQuery = true)
     Optional<Employees> getEmployeeByusernameAndPass(String phone,String pass);

     @Query(value = "SELECT * FROM employees WHERE statut='on' ", nativeQuery = true)
     List<Employees> getLocationOnlineEmployees();

}


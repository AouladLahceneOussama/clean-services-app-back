package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.demo.model.Services;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {

     @Query(value = "SELECT * FROM services WHERE id_emp = ?1 ", nativeQuery = true)
     List<Services> getServicesByusername(String phone);

     @Query(value = "SELECT * FROM services WHERE services.id_ser IN ?1", nativeQuery = true)
     List<Services> getFavoriteServices(String[] ids);
}



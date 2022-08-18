package com.example.demo.repository;

import com.example.demo.model.ServiceImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceImagesRepository extends JpaRepository<ServiceImages, Long>  {
    
}

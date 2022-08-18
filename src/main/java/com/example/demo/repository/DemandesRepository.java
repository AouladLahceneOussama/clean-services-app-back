package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

import com.example.demo.model.Demandes;

@Repository
public interface DemandesRepository extends JpaRepository<Demandes, Long> {

    @Query(value = "SELECT * FROM demandes WHERE statut= 'accept' and  date = ?1  and id_emp =?2 ", nativeQuery = true)
    List<Demandes> getDemandbyDate(Date date, String id_emp);

    @Query(value = "SELECT * FROM demandes WHERE statut= 'in progress'and id_emp =?1 ", nativeQuery = true)
    List<Demandes> getInProgressDemands(String id_emp);

    @Query(value = "SELECT * FROM demandes WHERE demandes.phone = ?1 AND demandes.is_deleted = 0 ORDER BY date,time DESC", nativeQuery = true)
    List<Demandes> getClientDemandes(String phone);
}
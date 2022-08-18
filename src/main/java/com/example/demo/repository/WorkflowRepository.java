package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Workflow;

@Repository
public interface WorkflowRepository extends JpaRepository<Workflow, Long> {

    // @Query("select a from articles a where a.demand.id_demand =?1 ")
    // @Query(value = "SELECT * FROM articles WHERE id_demand = ?1 ", nativeQuery = true)
    // List<Articles> getArticlesByDemandId(Long id_demand);
    
    @Query(value = "INSERT INTO workflow(id_emp,day) VALUES(:phone,:day)", nativeQuery = true)
    public void initialiseWorkflowNewEmployee(@Param("phone") String phone,@Param("day") String day);
}
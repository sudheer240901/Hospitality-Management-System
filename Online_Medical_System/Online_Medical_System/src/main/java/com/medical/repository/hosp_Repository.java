package com.medical.repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;


import com.medical.model.hospital;

import org.springframework.data.jpa.repository.JpaRepository;

public interface hosp_Repository extends JpaRepository<hospital,Integer>
{	
   @Query(value="select h.hospname from hospital h", nativeQuery=true)
   List<String> getHospname();
   
   List<hospital> findAll();
}
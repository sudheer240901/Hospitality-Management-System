package com.medical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medical.model.Doctor;


public interface Doc_Repository extends JpaRepository<Doctor,String> 
{
	Doctor findByMailed(String mailed);

	List<Doctor>  findBySpecalist(String health_issue);

    List<Doctor> findByHcode(int hcode);
	@Query(value="select * from doctor where hospname =:hospname and specalist =:specalist", nativeQuery=true)
	List<Doctor> ByDcotor_name(String hospname , String specalist);
	
}

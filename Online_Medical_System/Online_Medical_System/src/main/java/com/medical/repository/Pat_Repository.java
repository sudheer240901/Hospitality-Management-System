package com.medical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.medical.model.Appointment;

public interface Pat_Repository extends JpaRepository<Appointment , Integer>
{
	List<Appointment> findAll();
	Appointment findByPid(int pid);
	List<Appointment> findByConsultdoctor(String username);
	Appointment findByName(String fileName);
	List<Appointment> findByStatus(String status);
	@Query(value="select * from appointment where status =:status and consultdoctor =:uname", nativeQuery=true)
    List<Appointment> findByStatue(@Param("status") String status ,@Param("uname") String uname);
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update appointment set status =:status where pid =:pid",nativeQuery = true)
    void updateStatus(@Param("pid") int pid,@Param("status") String status);
	List<Appointment> findByMail(String uname);
	
}

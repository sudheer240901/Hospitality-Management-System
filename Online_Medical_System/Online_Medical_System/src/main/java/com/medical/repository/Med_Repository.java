package com.medical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.model.Medicalid;
import com.medical.model.Medicalreport;

public interface Med_Repository extends JpaRepository<Medicalreport,Medicalid>
{

	Medicalreport findByMedid(Medicalid mid);

    List<Medicalreport> findByMail(String mail);

	
}

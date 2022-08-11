package com.medical.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.model.Appointment;
import com.medical.model.Doctor;
import com.medical.model.Medicalreport;
import com.medical.model.Patient;
import com.medical.repository.Doc_Repository;
import com.medical.repository.Med_Repository;
import com.medical.repository.Pat_Repository;
import com.medical.repository.Repository;

@Service
public class Services 
{
	@Autowired 
	Med_Repository med_repo;
	@Autowired
	Repository repository;
	@Autowired
	Pat_Repository app_repository;
	@Autowired
	Doc_Repository doc_repo;
	public void save(Patient p)
	{
		repository.save(p);
	}
	public void save_app(Appointment app) 
	{
		
		app_repository.save(app);
	}
	public void save_doc(Doctor doc)
	{
		doc_repo.save(doc);
	}
	public void save_med(Medicalreport med)
	{
		med_repo.save(med);
	}
}

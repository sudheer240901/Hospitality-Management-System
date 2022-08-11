package com.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.medical.model.Patient;

public interface Repository extends JpaRepository<Patient , String>
{
	 Patient findByMail(String mail);
}

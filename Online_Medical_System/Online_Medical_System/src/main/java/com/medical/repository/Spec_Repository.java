package com.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.model.Spec;

public interface Spec_Repository extends JpaRepository<Spec,String>
{
	
}

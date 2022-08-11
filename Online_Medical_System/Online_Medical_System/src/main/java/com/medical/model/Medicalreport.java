package com.medical.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Medicalreport 
{
	@Id
	private Medicalid medid;

	
	private String mail;
	private Time time;
	
    public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Medicalid getMedid() {
		return medid;
	}
	public void setMedid(Medicalid medid) {
		this.medid = medid;
	}
}

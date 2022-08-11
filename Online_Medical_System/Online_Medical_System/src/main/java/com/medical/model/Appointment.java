package com.medical.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class Appointment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	private String mail;
	private String hospname;
	
	private String date;
	private String time;
	private String symptoms;
	private String health_issue;
	private String consultdoctor;
	private String name;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Lob
	private byte[] file;

	
	public String getConsultdoctor() {
		return consultdoctor;
	}
	public void setConsultdoctor(String consultdoctor) {
		this.consultdoctor = consultdoctor;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getHealth_issue() {
		return health_issue;
	}
	public void setHealth_issue(String health_issue) {
		this.health_issue = health_issue;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Appointment [pid=" + pid + ", mail=" + mail +  ", date=" + date + ", time=" + time
				+ ", Symptoms=" + symptoms + ", health_issue=" + health_issue + ", consult_doctor=" + consultdoctor
				+ "]";
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public String getHospname() {
		return hospname;


	
	}
	public void setHospname(String hospname) {
		this.hospname = hospname;
	}
}

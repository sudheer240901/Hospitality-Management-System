package com.medical.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Doctor 
{
	private String doctor_name;
	private String specalist;
	private int hcode;
	private String mailfrom;
	public String getMailfrom() {
		return mailfrom;
	}
	public void setMailfrom(String mailfrom) {
		this.mailfrom = mailfrom;
	}
	public int getHcode() {
		return hcode;
	}
	public void setHcode(int hcode) {
		this.hcode = hcode;
	}
	public String getHospname() {
		return hospname;
	}
	public void setHospname(String hospname) {
		this.hospname = hospname;
	}

	private String hospname;
	@Id
	private String mailed;
	public String getMailed() {
		return mailed;
	}
	public void setMailed(String mailed) {
		this.mailed = mailed;
	}

	private String mail_subject;
	@Column(length = 3000)
	private String mail_content;
	
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getSpecalist() {
		return specalist;
	}
	public void setSpecalist(String specalist) {
		this.specalist = specalist;
	}
	
	
	public String getMail_subject() {
		return mail_subject;
	}
	public void setMail_subject(String mail_subject) {
		this.mail_subject = mail_subject;
	}
	public String getMail_content() {
		return mail_content;
	}
	public void setMail_content(String mail_content) {
		this.mail_content = mail_content;
	}
	
	@Override
	public String toString() {
		return "Doctor [doctor_name=" + doctor_name + ", specalist=" + specalist + ", mail_subject=" + mail_subject + ", mail_content=" + mail_content
				 + "]";
	}
	
}

package com.medical.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class Medicalid implements Serializable
{
	private int pid;
	private String medicine;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	

}

package com.medical.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Spec 
{
	@Id
	private String healthissue;
	public String getHealthissue() {
		return healthissue;
	}
	public void setHealthissue(String healthissue) {
		this.healthissue = healthissue;
	}
	public String getSpealist() {
		return spealist;
	}
	public void setSpealist(String spealist) {
		this.spealist = spealist;
	}
	private String spealist;
}

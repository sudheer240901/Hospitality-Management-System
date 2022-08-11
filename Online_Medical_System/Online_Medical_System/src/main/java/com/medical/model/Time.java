package com.medical.model;

import javax.persistence.Embeddable;

@Embeddable
public class Time 
{
	
	private String morning;
	private String afternoon;
	private String night;
	public String getMorning() {
		return morning;
	}
	public void setMorning(String morning) {
		this.morning = morning;
	}
	public String getAfternoon() {
		return afternoon;
	}
	public void setAfternoon(String afternoon) {
		this.afternoon = afternoon;
	}
	public String getNight() {
		return night;
	}
	public void setNight(String night) {
		this.night = night;
	}
	
}

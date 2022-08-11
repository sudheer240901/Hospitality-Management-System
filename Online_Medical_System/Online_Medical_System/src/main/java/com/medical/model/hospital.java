package com.medical.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class hospital 
{
    @Id
    private  int hcode;
    private String hospname;
    private String hospadd;
    private  int nodoctors;
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
    public String getHospadd() {
        return hospadd;
    }
    public void setHospadd(String hospadd) {
        this.hospadd = hospadd;
    }
    public int getNodoctors() {
        return nodoctors;
    }
    public void setNodoctors(int nodoctors) {
        this.nodoctors = nodoctors;
    }
   
}

package com.medical.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.medical.model.hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.medical.model.hospital;
import com.medical.model.Appointment;
import com.medical.model.Doctor;
import com.medical.model.Patient;
import com.medical.model.Spec;
import com.medical.repository.Doc_Repository;
import com.medical.repository.Pat_Repository;
import com.medical.repository.Spec_Repository;
import com.medical.repository.hosp_Repository;
import com.medical.service.MailServiceImpl;
import com.medical.service.Services;
@RestController

public class Admin_controller 
{
	@Autowired
	Doc_Repository doct;
	@Autowired
	hosp_Repository hp_repo;
	@Autowired
	Spec_Repository sp_repo;
	@Autowired
	MailServiceImpl mailservice;
	@Autowired
	Services services;
	@Autowired
	Pat_Repository pat_repo;
	@RequestMapping("/creation")
	public ModelAndView creation(@ModelAttribute("doct") Doctor d,HttpServletRequest request)
	{
		
		String  dcontent = d.getMail_content();
		String dmail = d.getMailed();
		String dname = d.getDoctor_name();
		String newcontent = "Welcome to CREDI HEALTH "+dname+" your username is "+dmail+" and your password is "+dcontent+" . Thank You";
		d.setMail_content(newcontent);
		HttpSession h = request.getSession();
		String mailfrom = (String)h.getAttribute("uname");
		d.setMailfrom(mailfrom);
		mailservice.sendEmail(d);
		d.setMail_content(dcontent);
		services.save_doc(d);
		ModelAndView m = new ModelAndView();
		m.addObject("docts","Doctor Registration successfully completed");
		m.setViewName("ad_login");
		return m;
		
	}
	
	@RequestMapping("/doc_reg")
	public ModelAndView doc_reg()
	{
		ModelAndView m = new ModelAndView();
		List<Spec> ss = sp_repo.findAll();
		m.addObject("ss",ss);
		m.setViewName("doctor_creation");
		return m;
	}
	@RequestMapping("/creaspec")
	public ModelAndView created_spec()
	{
		ModelAndView m = new ModelAndView();
		m.setViewName("createspec");
		return m;
	}
	@RequestMapping("/spectz")
	public ModelAndView spectz(@ModelAttribute("specs") Spec s)
	{
		sp_repo.save(s);
		ModelAndView m = new ModelAndView();
		m.addObject("docts","Specalization Added successfully completed");
		m.setViewName("ad_login");
		return m;
	}
	@RequestMapping("/hospital")
	public ModelAndView hospital(@ModelAttribute("hosp") hospital h)
	{
		System.out.println(h.getHcode());
		System.out.println(h.getHospadd());
		System.out.println(h.getHospname());
		System.out.println(h.getNodoctors());
		hp_repo.save(h);
		ModelAndView m  = new ModelAndView();
		m.setViewName("ad_login");
		return m;
	}
	@RequestMapping("/hospital_cre")
	public ModelAndView hospital_cre()
	{
		ModelAndView m = new ModelAndView();
		m.setViewName("add_hospital");
		return m;
	}
	@RequestMapping("/hospital_list")
	public ModelAndView hospital_list()
	{
		List<hospital> hs = hp_repo.findAll();
		System.out.println(hs.get(0).getHcode());
		ModelAndView m = new ModelAndView();
		m.addObject("hs",hs);
		m.setViewName("hospital_list");
		return m;
	}
	@RequestMapping("/doctors/{hcode}")
	public ModelAndView doctors(@PathVariable("hcode") int hcode )
	{
		ModelAndView m = new ModelAndView();
		List<Doctor> ds = doct.findByHcode(hcode);
		m.addObject("ds",ds);
		m.setViewName("doctors_list");
		return m;
	}
	@RequestMapping("/adminpennding")
	public ModelAndView adminPending()
	{
		String pending = "pending";
		
		;
		List<Appointment> adpen = pat_repo.findByStatus(pending);
		ModelAndView m = new ModelAndView();
		m.addObject("adpen" , adpen);
		m.setViewName("adminspending");
		return m;

	}
}

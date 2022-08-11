package com.medical.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.medical.model.Appointment;
import com.medical.model.Doctor;
import com.medical.model.Medicalreport;
import com.medical.model.Patient;
import com.medical.model.Spec;
import com.medical.repository.Doc_Repository;
import com.medical.repository.Med_Repository;
import com.medical.repository.Pat_Repository;
import com.medical.repository.Repository;
import com.medical.repository.Spec_Repository;
import com.medical.repository.hosp_Repository;
import com.medical.service.MailServiceImpl;
import com.medical.service.Services;
@Controller
public class Patient_controller
{
	@Autowired
	MailServiceImpl mailservice;
	@Autowired
	hosp_Repository hp_repo;
	@Autowired
	Med_Repository med_repo;
	@Autowired
	Spec_Repository sp_repo;
	@Autowired
	Services service;
	@Autowired
	Pat_Repository repo;
	@Autowired
	Doc_Repository doc_repo;
	@Autowired
	Repository repos;

	List<Appointment> ant = new ArrayList();

	@RequestMapping("/appointment")
	public ModelAndView Appointment()
	{
		List<Spec> ss = sp_repo.findAll();
		List<String> hosps = hp_repo.getHospname();
		
		ModelAndView m = new ModelAndView();
		m.addObject("ss",ss);
		m.addObject("hosps",hosps);
		m.setViewName("appointment");
		return m;
		
	}
	
	@RequestMapping(value = "/app_request")
	public ModelAndView App_request(@ModelAttribute("appo") Appointment app,HttpServletResponse response)
	{
		
		System.out.println(app.getHospname());
		System.out.println(app.getHealth_issue());
		List<Doctor> dl = doc_repo.ByDcotor_name(app.getHospname(),app.getHealth_issue());

		System.out.println("Hello" +dl.get(0).getMailed());
		ModelAndView m = new ModelAndView();
		ant.add(app);
		System.out.println(app);
		m.addObject("app",app);
		m.addObject("dl",dl);
		m.setViewName("appointmentreq");
		return m;
	}

	@RequestMapping(value = "/app_requestss")
	public ModelAndView App_request(@RequestParam("consultdoctor") String consultdoctor,@RequestParam("file") MultipartFile file,HttpServletRequest request)
	{		
			Appointment app = ant.get(0);
			ant.remove(0);
			app.setConsultdoctor(consultdoctor);
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			System.out.println(fileName);
			app.setName(fileName);
			try {
				app.setFile(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			String uname = (String) request.getSession().getAttribute("uname");
			app.setMail(uname);
			Patient p = repos.findByMail(uname);
			if (p.getRole().equals("guest"))
			{
			app.setStatus("Success");
			
			ModelAndView m = new ModelAndView();
			m.addObject("id","Your Emergency Appoinment Done");
			m.setViewName("welcome");
			Doctor doctor  = new Doctor();
			String newcontent = "Welcome to Medicine Home "+uname+" your Appointment is done successfully. Thankyou for using our services" ;
			doctor.setMail_content(newcontent);
			doctor.setMailfrom(app.getConsultdoctor());
			doctor.setMail_subject("Appointment Status");
			doctor.setMailed(uname);
			mailservice.sendEmail(doctor);
			service.save_app(app);
			return m;
			}
			else{
				app.setStatus("pending");
				service.save_app(app);
			ModelAndView m = new ModelAndView();
			m.addObject("id","Your Appoinment request send successfully");
			m.setViewName("welcome");
			return m;
			}
			
			
			
	}
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request)
	{
		HttpSession h = request.getSession();
		String uname = (String)h.getAttribute("uname");
		System.out.println(uname);
		List<Appointment> l = repo.findByMail(uname);
		System.out.println(l);
		for(Appointment A:l)
		{
			System.out.println(A.getMail());
		}
		ModelAndView m = new ModelAndView();
		m.addObject("li",l);
		m.setViewName("list");
		return m;
	}
	@RequestMapping("/report/{pid}")
	public ModelAndView medical_report(@PathVariable("pid") int pid)
	{
		Appointment a = repo.findByPid(pid);
		String mail = a.getConsultdoctor();
		System.out.println(mail);
		List<Medicalreport> medi_rep = med_repo.findByMail(mail);
		int i;
		
		List<Medicalreport> news=new  ArrayList();
		for(i = 0;i<medi_rep.size();i++)
		{
			
			if (medi_rep.get(i).getMedid().getPid()==pid)
			{
				news.add(medi_rep.get(i));
			}
		}
		System.out.println(news);
		ModelAndView m = new ModelAndView();
		m.addObject("medi_rep",news);
		m.setViewName("report_view");
		return m;
	}
}

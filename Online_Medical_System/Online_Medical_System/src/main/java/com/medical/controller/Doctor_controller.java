package com.medical.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import com.medical.service.MailServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.medical.model.Appointment;
import com.medical.model.Doctor;
import com.medical.model.Medicalid;
import com.medical.model.Medicalreport;
import com.medical.model.Time;
import com.medical.repository.Med_Repository;
import com.medical.repository.Pat_Repository;
import com.medical.service.Services;



import org.springframework.http.MediaType;


@Controller
public class Doctor_controller 
{
	int i;
	
	List<Medicalreport> rep = new ArrayList();
	@Autowired
	MailServiceImpl mailservice;
	@Autowired
	Med_Repository med_rep;
	@Autowired
	Services ser;
	@Autowired
	Pat_Repository pat_repo;
	
	@RequestMapping("/view_patients/{uname}")
	public ModelAndView view_patients(@PathVariable("uname") String username )
	{
		
		List<Appointment> appoi = pat_repo.findByConsultdoctor(username);
		System.out.println(appoi);
		ModelAndView m = new ModelAndView();
		m.addObject("adpen",appoi);
		m.setViewName("patient_list");
		return m;
	}
	@RequestMapping(value = "/medical_report/{pid}",params = "Add")
	public ModelAndView medicalreports(@PathVariable("pid") int pid ,@RequestParam("medicine") String medicine,@RequestParam("time") String time[],HttpServletRequest request)
	{
		
		
		Medicalreport med = new Medicalreport();
		Medicalid mid = new Medicalid();
		mid.setPid(pid);
		mid.setMedicine(medicine);
		med.setMedid(mid);
		HttpSession hs = request.getSession();
		String mail = (String) hs.getAttribute("uname");
		med.setMail(mail);
		Time t = new Time();
		for (i = 0;i<time.length;i++)
		{
			
			if (time[i].equals("morning"))
			{
				t.setMorning("morning");
			}
			else if (time[i].equals("afternoon"))
			{
				t.setAfternoon("afternoon");
			}
			else
			{
				t.setNight("night");
			}
		}
		med.setTime(t);
		ser.save_med(med);
		
		Medicalreport medrep = med_rep.findByMedid(mid);
		
		ModelAndView medicines= new ModelAndView();
		rep.add(medrep);
		medicines.addObject("med" , rep);
		
		medicines.setViewName("medical_report");
		return medicines;
	}
	@RequestMapping(value = "/medical_report/{pid}", params = "Submit Medical record")
	public String medicalreportss(@PathVariable("pid") int pid ,@RequestParam("medicine") String medicine,@RequestParam("time") String time[],HttpServletRequest request)
	{
		Medicalreport med = new Medicalreport();
		Medicalid mid = new Medicalid();
		mid.setPid(pid);
		mid.setMedicine(medicine);
		med.setMedid(mid);
		HttpSession hs = request.getSession();
		String mail = (String) hs.getAttribute("uname");
		med.setMail(mail);
		Time t = new Time();
		for (i = 0;i<time.length;i++)
		{
			
			if (time[i].equals("morning"))
			{
				t.setMorning("morning");
			}
			else if (time[i].equals("afternoon"))
			{
				t.setAfternoon("afternoon");
			}
			else
			{
				t.setNight("night");
			}
		}
		med.setTime(t);
		ser.save_med(med);
		return "doct_dash";
		
	}
	
	@RequestMapping("/medical_request/{pid}")
	public String medical_request(@PathVariable("pid") int pid)
	{
		return "medical_report";
	}
	@Autowired
    private ServletContext servletContext;
	@GetMapping("/download/{pid}/")
public ResponseEntity downloadFromDB(@PathVariable int pid) {
	ServletContext servletContext = this.servletContext;
	Appointment document = pat_repo.findByPid(pid);
	String fileName = document.getName();
	String mineType = servletContext.getMimeType(fileName);
	return ResponseEntity.ok()
			.contentType(MediaType.parseMediaType(mineType))
			.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
			.body(document.getFile());
}
@RequestMapping("/adminpeending")
	public ModelAndView adminPending(HttpServletRequest request)
	{
		String pending = "pending";
		HttpSession h = request.getSession();
		String uname = (String)h.getAttribute("uname");
		List<Appointment> adpen = pat_repo.findByStatue(pending,uname);
		ModelAndView m = new ModelAndView();
		m.addObject("adpen" , adpen);
		m.setViewName("patient_list");
		return m;

	}
	@RequestMapping("/requestDoctor/{pid}")
	public ModelAndView requestDoctor(@PathVariable("pid") int pid,HttpServletRequest request)
	{
		Doctor doctor  = new Doctor();
		pat_repo.updateStatus(pid,"success");
		Appointment record = pat_repo.findByPid(pid);
		String newcontent = "Welcome to Medicine Home "+record.getMail()+" your Appointment is done successfully. Thankyou for using our services" ;
		doctor.setMail_content(newcontent);
		HttpSession h = request.getSession();
		String uname = (String)h.getAttribute("uname");
		doctor.setMailfrom(uname);
		doctor.setMail_subject("Appointment Status");
		doctor.setMailed(record.getMail());
		mailservice.sendEmail(doctor);
		ModelAndView m = new ModelAndView();
		m.addObject("message", "Appointment request Processed");
		String pending = "pending";
		List<Appointment> adpen = pat_repo.findByStatue(pending,uname);
		m.addObject("adpen" , adpen);
		m.setViewName("patient_list");
		return m;
		
	}

}

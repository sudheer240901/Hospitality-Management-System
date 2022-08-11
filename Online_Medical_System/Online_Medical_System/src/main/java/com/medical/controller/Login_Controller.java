package com.medical.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.medical.model.Doctor;
import com.medical.model.Patient;
import com.medical.repository.Doc_Repository;

import com.medical.repository.Pat_Repository;
import com.medical.repository.Repository;
import com.medical.service.Services;

@Controller
public class Login_Controller {
	int dec = -1;
	@Autowired
	Doc_Repository doc_rep;
	@Autowired
	Services services;
	@Autowired
	Repository repository;
	@Autowired
	Repository rep;
	@RequestMapping(value = "/signup")
	public String indexs() {
		return "indexs";
	}
	@PostMapping("/Emergency")
	public String Emergency(@ModelAttribute("emer") Patient e,HttpServletRequest request)
	{
		if (e.getName() == null || e.getMail() == null)
		{
			return "index";
		}
		HttpSession h = request.getSession();
		h.setAttribute("uname",e.getMail());
		System.out.println(e.getName());
		e.setRole("guest");
		rep.save(e);
		return "welcome";
	}
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/contactus")
	public String contactus() {
		return "contactus";
	}

	@RequestMapping("/Registering")
	public String registering(@ModelAttribute("pat") Patient p) {
		/* System.out.println(p); */
		p.setRole("user");
		services.save(p);
		return "indexs";
	}

	@RequestMapping("/Dash")
	public String dash() {
		if (dec == 0) {
			return "ad_login";
		} else if (dec == 1) {
			return "doct_dash";
		} else if (dec == 2) {
			return "welcome";
		} else {
			return "indexs";
		}
	}

	@RequestMapping("/Loginn")
	public String loginn(@RequestParam(value = "mail", defaultValue = "a") String mail,
			@RequestParam(value = "password", defaultValue = "b") String password, HttpServletRequest request,
			HttpServletResponse response) throws IOException 
	{

		System.out.println(mail + " " + password);
		System.out.println(!mail.equals("a")
				+ " " + !password.equals("b"));

		if (!mail.equals("a") && !password.equals("b")) 
		{
			if (mail.equals("admin@gmail.com") && password.equals("admin@gmail.com")) 
			{
				dec = 0;
				HttpSession hs = request.getSession();
				hs.setAttribute("uname", mail);
				return "redirect:/Dash";
			}

			else if (dec != 0) 
			{
				System.out.println("sfgs");
				Doctor d = doc_rep.findByMailed(mail);
				
				System.out.println("sfgdgfdgs");
				if (!(d == null))
				 {
					 System.out.println("dfvdf");
					/* System.out.println("dghdfg"); */
					String passd = d.getMail_content();
					/* System.out.println(passd+" "+password); */
					if (password.equals(passd))
					 {
						/* System.out.println("dghdfg"); */
						dec = 1;
						HttpSession hs = request.getSession();
						hs.setAttribute("uname", mail);
						return "redirect:/Dash";
					} 
					else
					 {
						return "redirect:/Dash";
					}
				}
			 else {
				System.out.println("aaaa");
				
				Patient p = repository.findByMail(mail);
				System.out.println("sfsfr"+p);
				if (!(p == null))
				{
				String pass = p.getPassword();
				if (password.equals(pass)) {
					dec = 2;
					HttpSession hs = request.getSession();
					hs.setAttribute("uname", mail);
					return "redirect:/Dash";
				}
				return "indexs";
			}
				return "indexs";
			}
		}
			else
			{
				return "indexs";
			}
		
	 }
	 else 
	 {
		 return "indexs";
	 }

	}

	@RequestMapping("/Logout")
	public void Logoutt(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession hs = request.getSession();
		hs.invalidate();
		dec = -1;
		/* System.out.println("helloworld"); */
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.sendRedirect("/Loginn");
	}
}

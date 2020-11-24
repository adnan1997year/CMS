package com.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cms.entities.Student;
import com.cms.service.StudentService;

@Controller
public class LoginController {
	
	@Autowired
	private StudentService studentService; 	
	
	@GetMapping("/login")
	public String login() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication == null || authentication instanceof AnonymousAuthenticationToken)
			return "login";
			
		return "redirect:/";
	}
	
	@GetMapping("/register")
	public String register(ModelMap model) {
		model.put("student", new Student());
		return "register";
	}
	
	@GetMapping("/login2")
	public String login2() {
		return "login_registration";
	}
	
	@PostMapping("/register")
	public String postRegister (Student student) {
		
		studentService.save(student);
		
		return "redirect:/login";
	}
}

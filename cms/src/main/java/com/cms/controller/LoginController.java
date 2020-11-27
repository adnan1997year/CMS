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
	public String register() {
		
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
	
	@PostMapping("/register_form")
	public String postRegister (Student student) {
		
		studentService.save(student);
		
		return "redirect:/login";
	}
	
	@GetMapping("/register_form")
	public String getRegister() {
		return "redirect:/register";
	}
}

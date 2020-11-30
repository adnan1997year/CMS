package com.cms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cms.entities.Student;
import com.cms.repositories.StudentRepository;
import com.cms.service.StudentService;

@Controller
public class LoginController {
	
	@Autowired
	private StudentService studentService; 	

	@Autowired
	StudentRepository userRepository;
	
	@GetMapping("/login")
	public String register() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication == null || authentication instanceof AnonymousAuthenticationToken)
			return "login";
			
		return "redirect:/";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("student", new Student());
			
		return "register";
	}
	
	@PostMapping("/register")
	public String postRegister (@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
	
		if(!student.getStdUsername().equals("") || student.getRetypePassword() != null) {
		 Student existing = userRepository.findByStdUsername(student.getStdUsername());
	     
		 if (existing != null)   
			 bindingResult.rejectValue("stdUsername", null, "There is already an account registered with this Username");
	     
		 
		 if(!student.getStdPassword().equals(student.getRetypePassword()))
			 bindingResult.rejectValue("retypePassword", null, "Password and Confirm Password are not same");
		}
		
		if(bindingResult.hasErrors()) {
			return "register"; 
		}
		
		studentService.save(student);
		
		return "redirect:/login";
	}
	
	@GetMapping("/register_form")
	public String getRegister() {
		return "redirect:/register";
	}
}

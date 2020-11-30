package com.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cms.entities.Student;

@Controller
public class HomeController {
	
	@GetMapping("/complain")
	public String complain() {
		return "insert_complain";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
}

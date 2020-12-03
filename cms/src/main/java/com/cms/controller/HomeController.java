package com.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cms.entities.Student;

@Controller
public class HomeController {
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
}

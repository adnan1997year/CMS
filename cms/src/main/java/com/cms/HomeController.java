package com.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "login_registration";
	}
	
	@GetMapping("/complain")
	public String complain() {
		return "insert_complain";
	}
}

package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cms.entities.Complain;
import com.cms.entities.ComplainCategory;
import com.cms.entities.Student;
import com.cms.repositories.ComplainCategoryRepository;
import com.cms.service.ComplainService;

@Controller
public class ComplainController {

	@Autowired
	ComplainCategoryRepository complainCategoryRepository;
	
	@Autowired
	ComplainService complainService;
	
	@GetMapping("/complain")
	public String showComplain(ModelMap model) {
		
		List<ComplainCategory> complainCategories = complainCategoryRepository.findAll();
		
		
		
		model.addAttribute("complaincategories", complainCategories);
		model.addAttribute("complain", new Complain());
		
		return "insert_complain";
	}
	
	@PostMapping("/complain")
	public String postComplain(@AuthenticationPrincipal Student student, Complain complain) {
		
		complain.setStudent(student);
		complainService.save(complain);
		
		return "redirect:/complain?success";
	}
}

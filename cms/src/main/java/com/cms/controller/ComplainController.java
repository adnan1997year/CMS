package com.cms.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cms.entities.Complain;
import com.cms.entities.ComplainCategory;
import com.cms.entities.Student;
import com.cms.repositories.ComplainCategoryRepository;
import com.cms.service.ComplainService;

@Controller
public class ComplainController {

	private final String UPLOAD_DIR = "./uploads/";
	
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
	public String postComplain(@AuthenticationPrincipal Student student, Complain complain, @RequestParam("file") MultipartFile file, RedirectAttributes attributes) {
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		 LocalDateTime now = LocalDateTime.now(); 
		 
		 String replacedSlashes = dtf.format(now).replaceAll("\\/","");
		 replacedSlashes = replacedSlashes.replaceAll(":","_");
		
		String fileLocation = UPLOAD_DIR + student.getStdId() + "/" + replacedSlashes;
		
		//creating directory if not exist.
		try { 
		  
		   Path path = Paths.get(fileLocation);

		    if (!Files.exists(path)) {
		    	
		    	 //java.nio.file.Files;
			    Files.createDirectories(path);
			    System.out.println("Directory is created!");
		    }

		  } catch (IOException e) {
		    System.err.println("Failed to create directory!" + e.getMessage());
		  }
		
		// check if file is empty
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/";
        }
        
        // normalize the file path
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        // save the file on the local file system
        try {
            Path path = Paths.get(fileLocation +"/"+ fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // return success response
        attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');

        complain.setFileLocation(fileLocation);
        
		complain.setStudent(student);
		complainService.save(complain);
		
		return "redirect:/complain?success";
	}
}

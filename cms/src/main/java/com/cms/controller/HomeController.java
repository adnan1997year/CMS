package com.cms.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	private final String UPLOAD_DIR = "./uploads/";
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
	@GetMapping("/upload")
	public String upload() {
		return "uploadTest";
	}
	@PostMapping("/upload")
	public String uploadPost(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {
		
		  try {

			    Path path = Paths.get(UPLOAD_DIR);

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
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // return success response
        attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');

        return "redirect:/";

	}
}

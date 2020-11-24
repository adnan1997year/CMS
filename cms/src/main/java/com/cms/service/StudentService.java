package com.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cms.entities.Student;
import com.cms.repositories.StudentRepository;
import com.cms.security.Authority;

@Service
public class StudentService {

	
	@Autowired
	private StudentRepository studentRepository; 
	@Autowired
	private PasswordEncoder passwordEncoder;
	private String encode;
	
	public Student save(Student student) {
		encode = passwordEncoder.encode(student.getStdPassword());
		student.setStdPassword(encode);
		
		Authority authority = new Authority();
		authority.setAuthority("ROLE_USER");
		authority.setStudent(student);
		
		student.getAuthorities().add(authority);
		
		return studentRepository.save(student);
	}
}

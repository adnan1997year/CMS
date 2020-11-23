package com.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cms.entities.Student;
import com.cms.repositories.UserRepository;
import com.cms.security.CustomSecurityStudent;

@Service
public class UserDetailsServiceImp implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		Student student = userRepository.findByStdUsername(username);
		
		if(student == null)
			throw new UsernameNotFoundException("Invalid Username not found");
		
		return new CustomSecurityStudent(student);
	}
}

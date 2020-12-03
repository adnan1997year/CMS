package com.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entities.Complain;
import com.cms.entities.ComplainCategory;
import com.cms.repositories.ComplainRepository;


@Service
public class ComplainService {

	
	@Autowired
	private ComplainRepository complainRepository; 
	
	public Complain save(Complain complain) {
		
		return complainRepository.save(complain);
	}
}

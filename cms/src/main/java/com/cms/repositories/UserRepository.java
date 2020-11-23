package com.cms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.entities.Student;

public interface UserRepository extends JpaRepository<Student, Integer>{

	Student findByStdUsername(String username);
	
}

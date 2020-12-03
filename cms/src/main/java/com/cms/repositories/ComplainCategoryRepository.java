package com.cms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cms.entities.ComplainCategory;

public interface ComplainCategoryRepository extends JpaRepository<ComplainCategory, Integer>{

	public List<ComplainCategory> findAll();
}

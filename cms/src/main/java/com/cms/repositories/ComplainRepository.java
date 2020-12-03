package com.cms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.entities.Complain;

public interface ComplainRepository extends JpaRepository<Complain, Integer>{}

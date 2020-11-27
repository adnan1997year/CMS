package com.cms.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.cms.entities.Student;

@Entity
@Table(name="Authority")
public class Authority implements GrantedAuthority{

	
	private static final long serialVersionUID = 8079522332371081675L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="authority")
	private String authority;
	
	@ManyToOne
	@JoinColumn(name="std_id")
	private Student studentAuth;
	
	@Override
	public String getAuthority() {

		return this.authority;
	}  

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return studentAuth;
	}

	public void setStudent(Student student) {
		this.studentAuth = student;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
}

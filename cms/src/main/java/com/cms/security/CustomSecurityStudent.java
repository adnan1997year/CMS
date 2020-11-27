package com.cms.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.cms.entities.Student;

public class CustomSecurityStudent extends Student implements UserDetails{

	private static final long serialVersionUID = -3870829784921374706L;
	
	public CustomSecurityStudent() {}
	
	public CustomSecurityStudent(Student student) {
		this.setAuthorities(student.getAuthorities());
		this.setStdId(student.getStdId());
		this.setStdName(student.getStdName());
		this.setStdGender(student.getStdGender());
		this.setStdCnic(student.getStdCnic());
		this.setStdAddress(student.getStdAddress());
		this.setStdPassword(student.getStdPassword());
		this.setRemarks(student.getRemarks());
	}
	
	@Override
	public Set<Authority> getAuthorities() {
		
		return super.getAuthorities();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getStdPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getStdUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

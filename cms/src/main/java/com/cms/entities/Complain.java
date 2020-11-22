package com.cms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="complain")
public class Complain implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="complain_cat_id")
	private ComplainCategory complainCategory;

	@ManyToOne
	@JoinColumn(name="std_id")
	private Student student;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="complain_id")
	private Integer complainId;
	
	@Column(name="complain_text")
	private String complainText;
	
	@Column(name="file_location")
	private String fileLocation;
	
	@Column(name="remarks")
	private String remarks;
	
	public ComplainCategory getComplainCategory() {
		return complainCategory;
	}

	public void setComplainCategory(ComplainCategory complainCategory) {
		this.complainCategory = complainCategory;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getComplainId() {
		return complainId;
	}

	public void setComplainId(Integer complainId) {
		this.complainId = complainId;
	}

	public String getComplainText() {
		return complainText;
	}

	public void setComplainText(String complainText) {
		this.complainText = complainText;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@Override
	public String toString() {
		return "Complain [complainCategory=" + complainCategory + ", student=" + student + ", complainId=" + complainId
				+ ", complainText=" + complainText + ", fileLocation=" + fileLocation + ", remarks=" + remarks + "]";
	}
}

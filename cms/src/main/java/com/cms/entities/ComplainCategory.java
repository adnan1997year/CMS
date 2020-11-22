package com.cms.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="complain_category")
public class ComplainCategory implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	

	@OneToMany(mappedBy="complainCategory")
	private List<Complain> complains;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="complain_cat_id")
	private Integer complainCatId;
	
	@Column(name="complain_cat_name")
	private String complainCatName;
	
	@Column(name="remarks")
	private String remarks;

	public List<Complain> getComplains() {
		return complains;
	}

	public void setComplains(List<Complain> complains) {
		this.complains = complains;
	}

	public Integer getComplainCatId() {
		return complainCatId;
	}

	public void setComplainCatId(Integer complainCatId) {
		this.complainCatId = complainCatId;
	}

	public String getComplainCatName() {
		return complainCatName;
	}

	public void setComplainCatName(String complainCatName) {
		this.complainCatName = complainCatName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "ComplainCategory [complains=" + complains + ", complainCatId=" + complainCatId + ", complainCatName="
				+ complainCatName + ", remarks=" + remarks + "]";
	}	

	
	 
}

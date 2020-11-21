package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="complain_category")
public class ComplainCategory implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE,
						CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="complain_id")
	private Complain complain;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="complain_cat_id")
	private Integer complainCatId;
	
	@Column(name="complain_cat_name")
	private String complainCatName;
	
	@Column(name="remarks")
	private String remarks;
	
	public ComplainCategory() {}
	
	public ComplainCategory(Integer complainCatId, String complainCatName, String remarks) {
		this.complainCatId = complainCatId;
		this.complainCatName = complainCatName;
		this.remarks = remarks;
	}
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
		return "ComplainCategory [complainCatId=" + complainCatId + ", complainCatName=" + complainCatName
				+ ", remarks=" + remarks + "]";
	}
	
	
	 
}

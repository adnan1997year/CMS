package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="complain")
public class Complain implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="instructor",
				cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						CascadeType.DETACH, CascadeType.REFRESH})
	private List<ComplainCategory> complainCategories;
	
	private List<Student> students;
	
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
	
	public Complain() {}
	
	public Complain(List<ComplainCategory> complainCategories, List<Student> students,
			Integer complainId, String complain,
			String complainText, String fileLocation, String remarks) {
		
		this.complainCategories = complainCategories;
		this.students = students;
		this.complainId = complainId;
		this.complainText = complainText;
		this.fileLocation = fileLocation;
		this.remarks = remarks;
	}
	
	public Complain(List<ComplainCategory> complainCategories, List<Student> students,
			String complainText, String fileLocation, String remarks) {
		
		this.complainCategories = complainCategories;
		this.students = students;
		this.complainText = complainText;
		this.fileLocation = fileLocation;
		this.remarks = remarks;
	}

	public Complain(Integer complainId, List<ComplainCategory> complainCategories, String complain,
			String complainText, String fileLocation, String remarks) {
		
		this.complainCategories = complainCategories;
		this.complainId = complainId;
		this.complainText = complainText;
		this.fileLocation = fileLocation;
		this.remarks = remarks;
	}
	
	public Complain(List<Student> students,
			Integer complainId, String complain,
			String complainText, String fileLocation, String remarks) {
		
		this.students = students;
		this.complainId = complainId;
		this.complainText = complainText;
		this.fileLocation = fileLocation;
		this.remarks = remarks;
	}
	
	public List<ComplainCategory> getComplainCatId() {
		return complainCategories;
	}

	public void setComplainCatId(List<ComplainCategory> complainCategories) {
		this.complainCategories = complainCategories;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}


	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
		return "Complain [complainCategories=" + complainCategories + ", students=" + students + ", complainId="
				+ complainId + ", complainText=" + complainText + ", fileLocation=" + fileLocation + ", remarks="
				+ remarks + "]";
	}

	
}

package cgginterns.hibernate.map3;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Subject {
	
	@Id
	@Column(name="subject_code")
	private int subjectCode;
	@Column(name="subject_name")
	private String subjectName;
	
	
	@ManyToMany(mappedBy="subjects")
	private List<Students> students;
	
	public Subject(int subjectCode, String subjectName) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
	}
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public List<Students> getStudents() {
		return students;
	}
	public void setStudents(List<Students> students) {
		this.students = students;
	}

	
	
	
}

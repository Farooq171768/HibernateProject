package cgginterns.hibernate.map3;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Students {
	
	@Id
	@Column(name="student_id")
	private int studentId;
	@Column(name="student_name")
	private String studentName;
	
	@ManyToMany
	private List<Subject> subjects;

	public Students(int studentId, String studentName, List<Subject> subjects) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.subjects = subjects;
	}

	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
	

}

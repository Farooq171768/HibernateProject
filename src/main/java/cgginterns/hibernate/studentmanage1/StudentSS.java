package cgginterns.hibernate.studentmanage1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentSS {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Student_id")
	private int studentId;
	@Column(name="Name")
	private String studentName;
	@Column(name="City")
	private String studentCity;
	@Column(name="Phone")
	private int studentPhone;
	
	
	public StudentSS(int studentId, String studentName, String studentCity, int studentPhone) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentCity = studentCity;
		this.studentPhone = studentPhone;
	}


	public StudentSS() {
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


	public String getStudentCity() {
		return studentCity;
	}


	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}


	public int getStudentPhone() {
		return studentPhone;
	}


	public void setStudentPhone(int studentPhone) {
		this.studentPhone = studentPhone;
	}

	
}

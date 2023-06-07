package cgginterns.hibernate.studentmanage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentManagement {
	
	@Id
	@Column(name="student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	@Column(name="student_name")
	private String name;
	@Column(name="student_phone")
	private int phone;
	@Column(name="student_city")
	private String city;
	
	public StudentManagement(int studentId, String name, int phone, String city) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.phone = phone;
		this.city = city;
	}

	public StudentManagement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
	
}

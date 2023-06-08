package cgg.hibernate.xmlmapping;

import java.util.List;

public class Department {
	private int deptId;
	private String deptName;
	private List<Employeee> employees;
	
	
	
	public Department(int deptId, String deptName, List<Employeee> employees) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.employees = employees;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public List<Employeee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employeee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", employees=" + employees + "]";
	}
	
	
	
	

}

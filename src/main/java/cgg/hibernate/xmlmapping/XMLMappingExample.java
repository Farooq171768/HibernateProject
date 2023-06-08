package cgg.hibernate.xmlmapping;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class XMLMappingExample {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		
		//Person person = new Person(110,"ABC","Hyd","1234");
		Department d = new Department();
		//d.setDepartmentId();
		d.setDeptName("cse");
		
		Employeee e1=new Employeee();
		//e1.setEmpId(11);
		e1.setName("XYZ");
		e1.setSalary(30000.0);
		e1.setDept(d);
		
		
		Employeee e2=new Employeee();
		//e2.setEmpId(12);
		e2.setName("PQR");
		e2.setSalary(20000.0);
		e2.setDept(d);
		
		Employeee e3=new Employeee();
		//e3.setEmpId(13);
		e3.setName("STU");
		e3.setSalary(25000.0);
		e3.setDept(d);
		
		
		ArrayList<Employeee> al=new ArrayList<>();
		al.add(e1);
		al.add(e2);
		al.add(e3);
		
		d.setEmployees(al);
		
		Transaction tx = session.beginTransaction();
		
		//session.save(person);
		session.save(d);
		
		tx.commit();
		session.close();
		factory.close();
	}

}

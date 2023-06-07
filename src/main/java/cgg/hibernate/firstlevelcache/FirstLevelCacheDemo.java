package cgg.hibernate.firstlevelcache;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cgginterns.hibernate.Student;

public class FirstLevelCacheDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Student student=null;
		System.out.println(session.contains(student));
		student=session.get(Student.class, 2);
		System.out.println(student);
		System.out.println(session.contains(student));
		

		System.out.println("Working something..............");
		
		Student student2 = session.get(Student.class, 2);
		System.out.println(student2);
		
		System.out.println(session.contains(student2));
		
		session.close();
		factory.close();
	}

}

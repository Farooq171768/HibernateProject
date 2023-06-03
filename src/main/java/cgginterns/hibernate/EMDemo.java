package cgginterns.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EMDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		
		//Create student object
		Student student = new Student();
		student.setId(101);
		student.setName("SER");
		student.setCity("HYD");
		student.setAddress("fhg");
		
		//create certificate object
		Certificate certi = new Certificate();
		certi.setCourse("Android");
		certi.setDuration("2 months");
		
		student.setCerti(certi);
		System.out.println(student);
		
		//creating another student object
		Student student1 = new Student();
		student1.setId(102);
		student1.setName("SUR");
		student1.setCity("HYD");
		student1.setAddress("fog");
		
		//create certificate object
		Certificate certi1 = new Certificate();
		certi1.setCourse("Hibernate");
		certi1.setDuration("3 months");
		
		student.setCerti(certi1);
		System.out.println(student1);
		
		Session session = factory.openSession();
		
		session.beginTransaction();
		session.save(student);
		session.save(student1);
		
		session.getTransaction().commit();

	}

}

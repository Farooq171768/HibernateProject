package cgginterns.hibernate.map3;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo3 {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		
		Students s1 = new Students();
		s1.setStudentId(1);
		s1.setStudentName("ABC");
		
		Students s2 = new Students();
		s2.setStudentId(2);
		s2.setStudentName("DEF");
		
		Subject sub1 = new Subject();
		sub1.setSubjectCode(101);
		sub1.setSubjectName("Maths");
		
		Subject sub2 = new Subject();
		sub2.setSubjectCode(102);
		sub2.setSubjectName("Science");
		
		 ArrayList<Students> list1 = new ArrayList<>();
		 list1.add(s1);
		 list1.add(s2);
		 
		 ArrayList<Subject> list2 = new ArrayList<>();
		 list2.add(sub1);
		 list2.add(sub2);
		 
		 s1.setSubjects(list2);
		 sub1.setStudents(list1);
		 
		 Session session = factory.openSession();
		 Transaction tx = session.beginTransaction();
		 
		 session.save(s1);
		 session.save(s2);
		 session.save(sub1);
		 session.save(sub2);
		 
		 tx.commit();
		 
		 Students students = (Students)session.get(Students.class, 1);
		 System.out.println(students.getStudentName());
		 
		 for(Subject s:students.getSubjects()) {
			 System.out.println(s.getSubjectName());
		 }
		 System.out.println("----------------");
		 
		 Subject subject = (Subject)session.get(Subject.class, 101);
		 System.out.println(subject.getSubjectName());
		 for(Students ss: subject.getStudents()) {
			 System.out.println(ss.getStudentName());
		 }
		factory.close();

	}

}

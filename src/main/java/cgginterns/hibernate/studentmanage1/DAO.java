package cgginterns.hibernate.studentmanage1;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import cgginterns.hibernate.studentmanage.HibernateUtil;

public class DAO {

	// Saving a student:
	public static void saveStudent(StudentSS student) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(student);
		
		
			System.out.println("Student(s) record added successfully");
			System.out.println("---------------------------------------------------");
		

		tx.commit();
		session.close();
	}

	// Getting info of all available students:
	 public static void getAllStudents(){
		 Session session = HibernateUtil.getSessionFactory().openSession();
			Query q= session.createQuery("from StudentSS");
			List<StudentSS> list = q.getResultList();
			for (StudentSS stu : list) {
				System.out.println(stu.getStudentId()+ ":" +stu.getStudentName()+ ":" +stu.getStudentCity() +":"+stu.getStudentPhone());
			}
			System.out.println("----------------------------------------------");
	 }

	// Updating student:
	public static void updateStudentName(String name, int i) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Query q = session.createQuery("update StudentSS set studentName= :n where studentId= :i");
		q.setParameter("n", name);
		q.setParameter("i", i);
		
		int r= q.executeUpdate();
		System.out.println(r   +"object(s) is/are updated");
		System.out.println("---------------------------------------------------");

		

		tx.commit();
		session.close();
		
	}

	public static void updateStudentCity(String city, int i) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Query q = session.createQuery("update StudentSS set studentCity= :c where studentId= :r");
		q.setParameter("c", city);
		q.setParameter("r", i);
		
		int r=q.executeUpdate();
		System.out.println(r  +"object(s) is/are updated");
		System.out.println("-------------------------------------------------------------");
		

		// session.update(city);

		tx.commit();
		session.close();
	}

	public static void updateStudentPhone(int phone, int i) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Query q1 = session.createQuery("update StudentSS set studentPhone= :p where studentId= :i");
		q1.setParameter("p", phone);
		q1.setParameter("i", i);
		
		int r=q1.executeUpdate();
		System.out.println(r  +"object(s) is/are updated");

		// session.update(phone);

		tx.commit();
		session.close();
		System.out.println("------------------------------------------------------");
	}

	// Deleting student:
	public static void deleteStudent(int s) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Query q1 = session.createQuery("delete from StudentSS s where s.studentId= :x");
		q1.setParameter("x", s);

		int r = q1.executeUpdate();
		System.out.println("deleted:");
		System.out.println(r);

//			session.delete(student);

		tx.commit();
		session.close();
		System.out.println("----------------------------------------------------");
	}

}

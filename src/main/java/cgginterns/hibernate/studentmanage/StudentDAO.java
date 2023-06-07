package cgginterns.hibernate.studentmanage;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAO {
	
	//Saving a student:
	public void saveStudent(StudentManagement student) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(student);
		
		tx.commit();
		session.close();
	}
	
	
	//Getting info of all available students:
	public List<StudentManagement> getAllStudent(){
		Session session= HibernateUtil.getSessionFactory().openSession();
		List<StudentManagement> students= session.createQuery("From StudentManagement",StudentManagement.class).list();
	    session.close();
		return students;
	}
	
	
	//Updating student:
	public void updateStudent(StudentManagement student) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(student);
		
		tx.commit();
		session.close();
	}
	
	
	//Deleting student:
	public void deleteStudent(StudentManagement student) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(student);
		
		
		tx.commit();
		session.close();
	}

}

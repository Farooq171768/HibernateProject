package cgg.hibernate.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import cgginterns.hibernate.Student;

public class HQLDemo {

	public static void main(String[] args) {
		SessionFactory factory =new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		//HQL Syntax:
		String query= "from Student s where s.city = :x  and s.name=:n ";
		Query q = session.createQuery(query);
		
		q.setParameter("x", "HYD");
		q.setParameter("n", "AAA");
		
		//single result- (unique)
		//multiple result- (list)
	
		List<Student> list=q.list();
		for(Student student : list) {
			System.out.println(student.getName() + ":" + student.getCity()+":"+student.getCerti().getCourse());
		}
		
		System.out.println("---------------------------");
		
		//Transaction tx = session.beginTransaction();
		
//		//delete query:
//		Query q1=session.createQuery("delete from Student s where s.city= :x");
//		q1.setParameter("x", "HYD");
//		
//		int r = q1.executeUpdate();
//		System.out.println("deleted:");
//		System.out.println(r);
		
		
		
		//Update query:
//		Query q2 = session.createQuery("update Student set city= :c where name= :n");
//		q2.setParameter("c", "Warangal");
//		q2.setParameter("n", "BBB");
//		
//		int r= q2.executeUpdate();
//		
//		System.out.println(r +" object(s) are/is updated");
//		
//		
//		
//		tx.commit();
		
		
		//How to execute join query
		Query q1=session.createQuery("select b.brandId,b.brandName,p.productName from Brand as b INNER JOIN b.products as p");
		List<Object []> list2 = q1.getResultList();
		
		for(Object[] arr: list2) {
			System.out.println(Arrays.toString(arr));
		}
		
		session.close();
        factory.close();
	}

}

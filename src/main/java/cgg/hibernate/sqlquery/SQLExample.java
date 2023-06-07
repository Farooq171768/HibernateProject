package cgg.hibernate.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQLExample {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		//SQL query
		
		String query="select * from student";
		NativeQuery nq = session.createNativeQuery(query);
		
		//Paging
		nq.setFirstResult(1); //starting index
		nq.setMaxResults(10);
		
		List<Object[]> list= nq.list();
		
		
		for(Object[] s: list) {
			//System.out.println(Arrays.toString(s));
			System.out.println(s[0] + " : "+ s[2]);
		}
		

		session.close();
		factory.close();
	}

}

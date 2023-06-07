package cgg.hibarnate.cascade;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cgginterns.hibernate.map1.Brand;
import cgginterns.hibernate.map1.Product;

public class CascadeExample {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Brand b1 = new Brand();
		b1.setBrandId(4);
		b1.setBrandName("Samaung");
		
		
		
		Product p1 = new Product(21,"Samaung Phone");
		Product p2 = new Product(22,"Samaung Laptop");
		Product p3 = new Product(23,"Samaung ACs");
		
		
		ArrayList<Product> list = new ArrayList<>();
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		b1.setProducts(list);
		
		Transaction tx = session.beginTransaction();
		
		session.delete(b1);

//		session.save(p1);
//		session.save(p2);
//		session.save(p3);
		
	
		
		tx.commit();
		session.close();
		factory.close();

	}

}

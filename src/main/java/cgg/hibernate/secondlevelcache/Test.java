package cgg.hibernate.secondlevelcache;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cgginterns.hibernate.map1.Brand;
import cgginterns.hibernate.map1.Product;

public class Test {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		

		Session session = factory.openSession();
		
		Brand b1 = session.get(Brand.class, 3);
		System.out.println(b1.getBrandName());
		List<Product> products = b1.getProducts();
		for(Product p : products) {
			System.out.println(p.getProductName());
		}
		session.close();
		
		
		Session session2 = factory.openSession();
		
		Brand b2 = session2.get(Brand.class, 3);
		System.out.println(b2.getBrandName());
		List<Product> products2 = b2.getProducts();
		for(Product p : products2) {
			System.out.println(p.getProductName());
		}
		session.close();
		session2.close();
		
		
		
		
		factory.close();
	}

}

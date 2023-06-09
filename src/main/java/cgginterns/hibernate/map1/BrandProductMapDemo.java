package cgginterns.hibernate.map1;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BrandProductMapDemo {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		
		//creating brand
		Brand brand = new Brand();
		brand.setBrandId(1);
		brand.setBrandName("TATA");
		
		
		//creating product object
		Product product = new Product();
		product.setProductId(11);
		product.setProductName("Tata Salt");
		product.setBrand(brand);
		
		Product product1 = new Product();
		product1.setProductId(12);
		product1.setProductName("Tata Car");
		product1.setBrand(brand);
		
		Product product2 = new Product();
		product2.setProductId(13);
		product2.setProductName("Tata Clothes");
		product2.setBrand(brand);
		
		ArrayList<Product> products = new ArrayList<>();
		products.add(product);
		products.add(product1);
		products.add(product2);
		
		brand.setProducts(products);
		
		
		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		
//		session.save(brand);
//		session.save(product);
//		session.save(product1);
//		session.save(product2);
//		
//		tx.commit();
		
		
		
		//Fetching objects
		Brand br=(Brand)session.get(Brand.class, 1);
		System.out.println(br.getBrandName());
		System.out.println(br.getProducts().size());
//		for(Product prod: br.getProducts()) {
//			System.out.println(prod.getProductName());
//		}
		
		session.close();
		
		
		factory.close();

	}

}

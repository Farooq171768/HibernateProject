package cgginterns.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	 System.out.println( "Program created" );
         
         SessionFactory factory =new Configuration().configure().buildSessionFactory();
//         System.out.println(factory);
//         
//         
//         System.out.println(factory.isClosed());
         
        //creating student object
         Student student = new Student();
         student.setId(2);
         student.setName("STUV");
         student.setCity("NZBM");
         student.setAddress("kdrt");
         
         //creating address object
         Address ad = new Address();
         ad.setStreet("street1");
         ad.setCity("Hyd");
         ad.setOpen(true);
         ad.setX(12.34);
         ad.setAddDate(new Date());
         
         //Reading image file and storing in database
         try(FileInputStream fis= new FileInputStream("src/main/java/Desert.jpeg")) {
         	byte [] data = new byte[fis.available()];
         	fis.read(data);
         	ad.setImage(data);
         	
         }
         catch(FileNotFoundException e){
         	e.printStackTrace();
         }
         catch(IOException e) {
         	e.printStackTrace();
         }
         
         
         
         Session session = factory.openSession(); //opening session
         
         //but for DML we need transaction:->DML always need transaction
        session.beginTransaction();
        
        session.save(student);
        session.save(ad);
        
        session.getTransaction().commit(); //commit means end of transaction
         
         
         session.close();//closing session
         factory.close();
         
         System.out.println("Done");
     }
}

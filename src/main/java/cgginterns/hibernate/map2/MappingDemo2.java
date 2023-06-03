package cgginterns.hibernate.map2;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo2 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
		//Creating Employee1
		Employee e = new Employee();
		e.setEmployeeId(1);
		e.setEmployeeName("Vamshi");

		//Creating Employee2
		Employee e1 = new Employee();
		e1.setEmployeeId(2);
		e1.setEmployeeName("Farooq");

		
		Project proj = new Project();
		proj.setProjectId(11);
		proj.setProjectName("Library Management");

		Project proj1 = new Project();
		proj1.setProjectId(12);
		proj1.setProjectName("ChatBot");

		List<Employee> list1 = new ArrayList<>();
		list1.add(e);
		list1.add(e1);

		List<Project> list2 = new ArrayList<>();
		list2.add(proj);
		list2.add(proj1);

		e1.setProjects(list2);
		proj1.setEmployees(list1);
		
		e1.getProjects().add(proj);
		proj1.getEmployees().add(e1);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(e);
		session.save(e1);
		session.save(proj);
		session.save(proj1);
		

		tx.commit();
		
		Employee emp1= (Employee)session.get(Employee.class, 2);
		System.out.println(emp1.getEmployeeName());
		for(Project p : emp1.getProjects() ) {
			System.out.println(p.getProjectName());
		}
		System.out.println("---------------");
		
		Project project =(Project) session.get(Project.class, 12);
		System.out.println(project.getProjectName());
		for(Employee em: project.getEmployees()) {
			System.out.println(em.getEmployeeName());
		}
		
		
		factory.close();

	}

}

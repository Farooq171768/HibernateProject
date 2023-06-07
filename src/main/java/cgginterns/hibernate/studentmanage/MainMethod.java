package cgginterns.hibernate.studentmanage;

import java.util.List;

public class MainMethod {

	public static void main(String[] args) {
		StudentDAO studentDAO = new StudentDAO();

		//creating and saving a new student:
		StudentManagement management = new StudentManagement();
		
		management.setName("Farooq");
		management.setCity("WNP");
		management.setPhone(123456);
		
		StudentManagement management1 = new StudentManagement();
		
		management.setName("Akash");
		management.setCity("NZB");
		management.setPhone(654321);
		studentDAO.saveStudent(management1);
		
		//Fetching all students:
		List<StudentManagement> students= studentDAO.getAllStudent();
		for (StudentManagement student : students) {
			 System.out.println("ID: " + student.getStudentId());
	            System.out.println("Name: " + student.getName());
	            System.out.println("City: " + student.getCity());
	            System.out.println("Phone: " + student.getPhone());
	            System.out.println("----------------------------------");
		}
		
		
		
		//Update a student:
//		StudentManagement studentToUpdate= students.get(1);
//		studentToUpdate.setName("Akash");
//		studentToUpdate.setStudentId(2);
//		studentToUpdate.setCity("NZB");
//		studentToUpdate.setPhone(675464454);
//		studentDAO.updateStudent(studentToUpdate);
		
		
		//Deleting a student:
		StudentManagement studentToDelete= students.get(1);
		studentDAO.deleteStudent(studentToDelete);
	}

}
